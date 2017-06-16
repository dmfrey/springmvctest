package io.pivotal.dmfrey.spring.endpoint;

import io.pivotal.dmfrey.spring.service.SampleService;
import io.pivotal.dmfrey.spring.service.SampleServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dmfrey on 6/15/17.
 */
@Controller
public class SampleController {

    private final SampleService sampleService;

    @Autowired
    public SampleController( final SampleService sampleService ) {

        this.sampleService = sampleService;

    }

    @RequestMapping( value = "/sample/process", method = { RequestMethod.GET, RequestMethod.POST }, consumes = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<String> process() throws SampleServiceException {

        this.sampleService.doSomething();

        return new ResponseEntity<>( HttpStatus.OK );
    }

    @ExceptionHandler( SampleServiceException.class )
    public ResponseEntity<String> handleSampleServiceException( SampleServiceException e ) {

        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR );
    }

}

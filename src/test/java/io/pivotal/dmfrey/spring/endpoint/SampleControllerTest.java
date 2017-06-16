package io.pivotal.dmfrey.spring.endpoint;

import io.pivotal.dmfrey.spring.service.SampleService;
import io.pivotal.dmfrey.spring.service.SampleServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dmfrey on 6/15/17.
 */
public class SampleControllerTest {

    @Mock
    private SampleService service;

    private SampleController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {

        MockitoAnnotations.initMocks( this );

        this.controller = new SampleController( service );

        this.mockMvc = MockMvcBuilders
                .standaloneSetup( this.controller )
                .build();

    }

    @Test
    public void testProcess() throws Exception {

        when( service.doSomething() ).thenReturn( "it's done!" );

        this.mockMvc.perform(
                post( "/sample/process" )
                        .contentType( MediaType.APPLICATION_JSON )
                )
                .andExpect( status().isOk() );

        verify( service, times( 1 ) ).doSomething();

    }

    @Test
    public void testProcess_verifySampleServiceException() throws Exception {

        when( service.doSomething() ).thenThrow( new SampleServiceException() );

        this.mockMvc.perform(
                post( "/sample/process" )
                        .contentType( MediaType.APPLICATION_JSON )
        )
                .andExpect( status().isInternalServerError() );

        verify( service, times( 1 ) ).doSomething();

    }

}

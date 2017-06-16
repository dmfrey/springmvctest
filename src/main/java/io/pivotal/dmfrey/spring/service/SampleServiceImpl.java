package io.pivotal.dmfrey.spring.service;


/**
 * Created by dmfrey on 6/15/17.
 */
public class SampleServiceImpl implements SampleService {

    @Override
    public String doSomething() throws SampleServiceException {

        return "I did it!";
    }

}

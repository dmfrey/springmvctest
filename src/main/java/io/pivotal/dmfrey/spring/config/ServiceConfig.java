package io.pivotal.dmfrey.spring.config;

import io.pivotal.dmfrey.spring.service.SampleService;
import io.pivotal.dmfrey.spring.service.SampleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dmfrey on 6/15/17.
 */
@Configuration
public class ServiceConfig {

    @Bean
    public SampleService sampleService() {

        return new SampleServiceImpl();
    }
}

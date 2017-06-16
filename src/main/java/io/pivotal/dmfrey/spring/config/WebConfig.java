package io.pivotal.dmfrey.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by dmfrey on 6/15/17.
 */
@Configuration
@EnableWebMvc
@ComponentScan( "io.pivotal.dmfrey.spring.endpoint")
public class WebConfig extends WebMvcConfigurerAdapter {

}

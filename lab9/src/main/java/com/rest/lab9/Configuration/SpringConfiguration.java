package com.rest.lab9.Configuration;

import com.rest.lab9.BusinessLogic.models.mappers.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public CustomerMapper mapper() {
        return new CustomerMapper();
    }
}

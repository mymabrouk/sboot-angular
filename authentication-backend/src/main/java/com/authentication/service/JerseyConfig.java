package com.authentication.service;

import org.springframework.stereotype.Component;

import org.glassfish.jersey.server.ResourceConfig;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(AuthenticationService.class);
        register(ValidationService.class);
    }

}

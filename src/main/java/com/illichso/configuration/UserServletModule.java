package com.illichso.configuration;

import com.google.inject.Scopes;
import com.illichso.rest.UserController;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

public class UserServletModule extends com.google.inject.servlet.ServletModule {
    @Override
    protected void configureServlets() {
        // bind resource classes here
        bind(UserController.class);

        // hook Jersey into Guice Servlet
        bind(com.sun.jersey.guice.spi.container.servlet.GuiceContainer.class);

        // hook Jackson into Jersey as the POJO <-> JSON mapper
        bind(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class).in(Scopes.SINGLETON);

        Map<String, String> guiceContainerConfig = new HashMap<>();
        guiceContainerConfig.put(ResourceConfig.PROPERTY_RESOURCE_FILTER_FACTORIES,
                UserController.class.getCanonicalName());

        serve("/*").with(GuiceContainer.class, guiceContainerConfig);
    }
}

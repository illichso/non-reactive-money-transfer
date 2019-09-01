package com.illichso.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class SandwichServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        // bind resource classes here

        // hook Jersey into Guice Servlet
        bind(GuiceContainer.class);

        // hook Jackson into Jersey as the POJO <-> JSON mapper
        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

//        Map<String, String> guiceContainerConfig = new HashMap<String, String>();
//        guiceContainerConfig.put(ResourceConfig.PROPERTY_RESOURCE_FILTER_FACTORIES,
//                HttpStatusCodeMetricResourceFilterFactory.class.getCanonicalName());

        serve("/*").with(GuiceContainer.class);
    }
}
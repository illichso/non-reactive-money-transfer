package com.illichso.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.servlet.GuiceFilter;
import com.illichso.Main;
import com.illichso.configuration.guice.GuiceServletConfig;
import com.illichso.configuration.guice.GuiceToHK2;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;
import static org.glassfish.jersey.server.ServerProperties.PROVIDER_PACKAGES;

public class Application {
    public void run() throws Exception {
        Server jettyServer = new Server(8080);
        ServletContextHandler httpContext = new ServletContextHandler(jettyServer, "/");
        httpContext.addEventListener(new GuiceServletConfig());
        httpContext.addFilter(GuiceFilter.class, "/*", null);
        httpContext.addServlet(new ServletHolder(new ServletContainer(buildResourceConfig())), "/*");
        jettyServer.setHandler(httpContext);
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }

//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        ServletContainer container = new ServletContainer(buildResourceConfig());
//        ServletHolder holder = new ServletHolder(container);
//        context.setContextPath("/");
//        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
//        jerseyServlet.setInitParameter(PROVIDER_PACKAGES, "com.illichso.rest");
//        jerseyServlet.setInitOrder(0);
//
//        Server jettyServer = new Server(8080);
//        jettyServer.setHandler(context);
//
//        try {
//            jettyServer.start();
//            jettyServer.join();
//        } finally {
//            jettyServer.destroy();
//        }
    }

    private ResourceConfig buildResourceConfig() {
        ResourceConfig config = new ResourceConfig();
        config.register(new GuiceToHK2(Main.injector));
        config.register(JacksonJsonProvider.class);
        config.registerClasses(EncodingFilter.class, GZipEncoder.class, DeflateEncoder.class);
        config.packages("com.illichso");
        return config;
    }
}

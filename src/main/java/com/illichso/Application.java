package com.illichso;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.illichso.configuration.module.DbModule;
import com.illichso.configuration.module.UserModule;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;
//import static org.glassfish.jersey.server.ServerProperties.PROVIDER_PACKAGES;

//import org.glassfish.jersey.server.ResourceConfig;

public class Application {
    public static void main(String[] args) throws Exception {
        initInjections();
        launchServer();

//        launchServer2();
//        launchServer3();
    }

    private static void initInjections() {



//        Injector injector = Guice.createInjector(new InjectionModule());
//        AccountRepositoryJPA accountRepository = injector.getInstance(AccountRepositoryJPA.class);
//        UserRepositoryJPA userRepository = injector.getInstance(UserRepositoryJPA.class);

//        AccountServiceImpl accountService = injector.getInstance(AccountServiceImpl.class);
//        UserServiceImpl userService = injector.getInstance(UserServiceImpl.class);
    }

    private static void launchServer() throws Exception {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                binder().requireExplicitBindings();

                install(new UserModule());
                install(new DbModule());
//                install(new JerseyMetricsModule());

                bind(GuiceFilter.class);
//                bind(MetricRegistry.class).toInstance(new MetricRegistry());
            }
        });

        ServletContextHandler handler = new ServletContextHandler(SESSIONS);
        handler.setContextPath("/");

        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        handler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

        ServletHolder jerseyServlet = handler.addServlet(ServletContainer.class, "/*");
//        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "com.illichso.rest");
//        jerseyServlet.setInitOrder(0);

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(handler);
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }

//    private static void launchServer3() throws Exception {
//        Server server = new Server(8080);
//        ServletContextHandler context = new ServletContextHandler(SESSIONS);
//        context.setContextPath("/");
//        server.setHandler(context);
////        ServerConnector connector = new ServerConnector(server);
////        connector.setPort(8080);
////        server.setConnectors(new Connector[] {connector});
//
//        try {
//            server.start();
//            server.join();
//        } finally {
//            server.destroy();
//        }
//
//    }


//    private static void launchServer2() throws Exception {
//        ResourceConfig config = new ResourceConfig();
//        config.packages("com.illichso");
//        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
//
//
//        Server server = new Server(8080);
//        ServletContextHandler context = new ServletContextHandler(server, "/*");
//        context.addServlet(servlet, "/*");
//
//
//        try {
//            server.start();
//            server.join();
//        } finally {
//            server.destroy();
//        }
//    }
}

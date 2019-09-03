package com.illichso;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;
import com.illichso.configuration.Application;
import com.illichso.configuration.guice.module.AccountModule;
import com.illichso.configuration.guice.module.DBModule;
import com.illichso.configuration.guice.module.UserModule;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Injector injector;

    public static void main(String[] args) throws Exception {

        List<AbstractModule> modules = new ArrayList<>();
        modules.add(new DBModule());
        modules.add(new ServletModule());
        modules.add(new AccountModule());
        modules.add(new UserModule());
        injector = Guice.createInjector(modules);
        injector.getInstance(Application.class).run();

//        initInjections();
//        launchServer();

//        launchServer2();
//        launchServer3();
    }
//
//    private static void initInjections() {
//        Injector injector = Guice.createInjector(new InjectionModule());
////        AccountRepositoryJPA accountRepository = injector.getInstance(AccountRepositoryJPA.class);
////        UserRepositoryJPA userRepository = injector.getInstance(UserRepositoryJPA.class);
//
////        AccountServiceImpl accountService = injector.getInstance(AccountServiceImpl.class);
////        UserServiceImpl userService = injector.getInstance(UserServiceImpl.class);
//    }

//    private static void launchServer() throws Exception {
//        ServletContextHandler context = new ServletContextHandler(SESSIONS);
//        context.setContextPath("/");
//
//        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
//        jerseyServlet.setInitParameter(PROVIDER_PACKAGES, "com.illichso.rest");
//        jerseyServlet.setInitOrder(0);
//
//        Server jettyServer = new Server(8080);
//        jettyServer.setHandler(context);
//        try {
//            jettyServer.start();
//            jettyServer.join();
//        } finally {
//            jettyServer.destroy();
//        }
//    }
//
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
//
//
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

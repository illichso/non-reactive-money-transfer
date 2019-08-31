package com.illichso;

import com.illichso.rest.AccountController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Application {
    public static void main(String[] args) throws Exception {
        launchServer1();

//        launchServer2();
//        launchServer3();
    }

    private static void launchServer1() throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", AccountController.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }





    private static void launchServer3() throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
//        ServerConnector connector = new ServerConnector(server);
//        connector.setPort(8080);
//        server.setConnectors(new Connector[] {connector});

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }

    }



    private static void launchServer2() throws Exception {
        ResourceConfig config = new ResourceConfig();
        config.packages("com.illichso");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");


        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}

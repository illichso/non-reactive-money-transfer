package com.illichso.configuration.guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.illichso.Main;

public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Main.injector;
    }

}
//package com.illichso.configuration;
//
//import com.google.inject.Guice;
//import com.google.inject.Injector;
//import org.glassfish.hk2.api.ServiceLocator;
//import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
//import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
//
//import javax.annotation.Priority;
//import javax.ws.rs.core.Feature;
//import javax.ws.rs.core.FeatureContext;
//
//@Priority(1)
//public class GuiceFeature implements Feature {
//    @Override
//    public boolean configure(FeatureContext context) {
//        ServiceLocator locator = org.glassfish.hk2.api.ServiceLocator.getServiceLocator(context);
//        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
//        Injector injector = Guice.createInjector(new UserModule());
//        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
//        guiceBridge.bridgeGuiceInjector(injector);
//        return true;
//    }
//}
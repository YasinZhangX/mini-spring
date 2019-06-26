package com.yasin.starter;

import com.yasin.core.ClassScanner;
import com.yasin.web.handler.HandlerManager;
import com.yasin.web.server.TomcatServer;

import java.util.List;

/**
 * @author yasin
 */
public class MiniApplication {

    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello, Mini-Spring");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            HandlerManager.resolveMappingHandler(classList);
            classList.forEach(it -> System.out.println(it.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

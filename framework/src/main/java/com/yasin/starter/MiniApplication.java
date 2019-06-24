package com.yasin.starter;

import com.yasin.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * @author yasin
 */
public class MiniApplication {

    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello, Mini-Spring");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}

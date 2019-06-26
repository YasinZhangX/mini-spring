package com.yasin.web.servlet;

import com.yasin.web.handler.HandlerManager;
import com.yasin.web.handler.MappingHandler;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Yasin Zhang
 */
public class DispatcherServlet implements Servlet {


    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        for (MappingHandler mappingHandler : HandlerManager.mappingHandlerList) {
            try {
                if (mappingHandler.handle(req, res)) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

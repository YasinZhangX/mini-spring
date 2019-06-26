package com.yasin.web.handler;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yasin
 */
public class MappingHandler {

    private String uri;

    private Class<?> controller;
    private Method method;
    private String[] args;

    MappingHandler(String uri, Class<?> cls, Method method, String[] args) {
        this.uri = uri;
        this.controller = cls;
        this.method = method;
        this.args = args;
    }

    public boolean handle(ServletRequest req, ServletResponse res)
        throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String requestUri = ((HttpServletRequest)req).getRequestURI();
        if (!uri.equals(requestUri)) { // 判断是否可以处理当前uri
            return false;
        }

        Object[] parameters = new Object[args.length];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = req.getParameter(args[i]);
        }

        Object ctrl = controller.newInstance();
        Object response = method.invoke(ctrl, parameters);  // 调用函数
        res.getWriter().println(response.toString());

        return true;
    }
}

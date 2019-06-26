package com.yasin.web.handler;

import com.yasin.web.mvc.Controller;
import com.yasin.web.mvc.RequestMapping;
import com.yasin.web.mvc.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yasin
 */
public class HandlerManager {

    public static List<MappingHandler> mappingHandlerList = new ArrayList<>();

    public static void resolveMappingHandler(List<Class<?>> classList) {
        for (Class<?> cls : classList) {
            if (cls.isAnnotationPresent(Controller.class)) {
                parseHandlerFromController(cls);
            }
        }
    }

    private static void parseHandlerFromController(Class<?> cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(RequestMapping.class)) {
                continue;
            }
            String uri = method.getDeclaredAnnotation(RequestMapping.class).value();  // 获取被RequestMapping注解的方法
            List<String> paramNameList = new ArrayList<>();
            for (Parameter parameter : method.getParameters()) {
                if (parameter.isAnnotationPresent(RequestParam.class)) {  // 获取被RequestParam注解的参数
                    paramNameList.add(parameter.getDeclaredAnnotation(RequestParam.class).value());
                }
            }
            String[] params = paramNameList.toArray(new String[0]);

            // 添加MappingHandler
            MappingHandler mappingHandler = new MappingHandler(uri, cls, method, params);
            HandlerManager.mappingHandlerList.add(mappingHandler);
        }
    }

}

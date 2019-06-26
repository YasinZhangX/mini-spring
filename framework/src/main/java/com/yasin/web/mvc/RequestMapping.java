package com.yasin.web.mvc;

import java.lang.annotation.*;

/**
 * @author yasin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {

    String value();

}

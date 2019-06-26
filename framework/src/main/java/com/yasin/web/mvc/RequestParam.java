package com.yasin.web.mvc;

import java.lang.annotation.*;

/**
 * @author yasin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {

    String value();

}

package com.yasin.beans;

import java.lang.annotation.*;

/**
 * @author yasin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoWired {
}

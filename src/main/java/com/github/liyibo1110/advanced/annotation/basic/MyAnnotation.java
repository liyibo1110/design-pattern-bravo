package com.github.liyibo1110.advanced.annotation.basic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liyibo
 * @date 2025-10-16 15:14
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String getValue() default "no description";
}

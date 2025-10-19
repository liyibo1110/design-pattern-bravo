package com.github.liyibo1110.advanced.reflection.printclassinfo.clazz;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liyibo
 * @date 2025-10-17 11:48
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
}

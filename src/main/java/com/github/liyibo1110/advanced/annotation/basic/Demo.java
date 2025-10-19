package com.github.liyibo1110.advanced.annotation.basic;

/**
 * @author liyibo
 * @date 2025-10-16 15:56
 */
@MyAnnotation(getValue="annotation on class")
public class Demo {

    @MyAnnotation(getValue="annotation on field")
    public String name;

    @MyAnnotation(getValue="annotation on method")
    public void hello() {

    }

    @MyAnnotation
    public void defaultMethod() {

    }
}

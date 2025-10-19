package com.github.liyibo1110.advanced.annotation.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liyibo
 * @date 2025-10-16 15:57
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        // 获取类上的注解
        Class<Demo> clazz = Demo.class;
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getValue());

        // 获取成员变量上的注解
        Field name = clazz.getField("name");
        MyAnnotation annotationOnField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnField.getValue());

        // 获取hello方法上的注解
        Method hello = clazz.getMethod("hello", null);
        MyAnnotation annotationOnMethod = hello.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.getValue());

        // 获取defaultMethod方法上的注解
        Method defaultMethod = clazz.getMethod("defaultMethod", null);
        MyAnnotation annotationOnDefaultMethod = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnDefaultMethod.getValue());
    }
}

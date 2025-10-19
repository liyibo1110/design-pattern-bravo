package com.github.liyibo1110.advanced.reflection.printclassinfo.clazz;

/**
 * @author liyibo
 * @date 2025-10-17 11:48
 */
@FunctionalInterface
@MyAnnotation("annotation on MyInterface")
public interface MyInterface<T, R> {
    R interfaceMethod(T param);
}

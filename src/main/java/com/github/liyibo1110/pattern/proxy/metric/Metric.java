package com.github.liyibo1110.pattern.proxy.metric;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 监控注解
 * @author liyibo
 * @date 2025-10-27 18:05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Metric {
    /** 业务标签 */
    String bizTag() default "";

    /** 业务副标签 */
    String bizSubTag() default "";
}

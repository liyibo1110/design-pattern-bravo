package com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.aop;

import com.github.liyibo1110.pattern.proxy.metric.Metric;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author liyibo
 * @date 2025-10-28 11:03
 */
public class ApplicationContext {
    @SneakyThrows
    public Object getBean(String name) {
        Class<?> clazz = Class.forName(name);
        // 构建原始对象
        Object target = clazz.newInstance();
        // 判断是否需要代理
        if(this.needProxy(clazz))
            return CglibMetricAspect.createProxy(target);   // 只有这里不同，换成了CglibMetricAspect
        return target;
    }

    private boolean needProxy(Class<?> clazz) {
        // 检查类上是否有Metric注解
        for(Method m : clazz.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Metric.class))
                return true;
        }
        // 检查接口上是否有Metric注解
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class<?> c : interfaces) {
            for(Method m : c.getDeclaredMethods()) {
                if(m.isAnnotationPresent(Metric.class))
                    return true;
            }
        }
        return false;
    }
}

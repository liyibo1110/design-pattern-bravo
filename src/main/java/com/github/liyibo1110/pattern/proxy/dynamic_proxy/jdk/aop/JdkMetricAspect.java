package com.github.liyibo1110.pattern.proxy.dynamic_proxy.jdk.aop;

import com.github.liyibo1110.pattern.proxy.metric.Metric;
import com.github.liyibo1110.pattern.proxy.metric.MetricTag;
import com.github.liyibo1110.pattern.proxy.metric.MetricUtil2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟Spring Aspect
 * @author liyibo
 * @date 2025-10-28 10:41
 */
public class JdkMetricAspect implements InvocationHandler {
    private final Object target;

    public JdkMetricAspect(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
          target.getClass().getClassLoader(),
          target.getClass().getInterfaces(),
          new JdkMetricAspect(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取目标实例方法上的注解
        Metric metric = method.getAnnotation(Metric.class);
        if(metric == null)
            return method.invoke(target, args);
        return MetricUtil2.metric(() -> method.invoke(target, args),
                (result, initialTagMap) -> {
                    initialTagMap.put(MetricTag.BIZ_TAG, metric.bizTag());
                    initialTagMap.put(MetricTag.BIZ_SUB_TAG, metric.bizSubTag());
                });
    }
}

package com.github.liyibo1110.pattern.proxy.dynamic_proxy.cglib.aop;

import com.github.liyibo1110.pattern.proxy.metric.Metric;
import com.github.liyibo1110.pattern.proxy.metric.MetricTag;
import com.github.liyibo1110.pattern.proxy.metric.MetricUtil2;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liyibo
 * @date 2025-10-28 11:01
 */
public class CglibMetricAspect implements MethodInterceptor {
    private final Object target;

    public CglibMetricAspect(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibMetricAspect(target));
        return (T)enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
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

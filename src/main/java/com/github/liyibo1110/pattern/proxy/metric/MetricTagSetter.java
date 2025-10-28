package com.github.liyibo1110.pattern.proxy.metric;

import java.util.Map;

/**
 * 标签设置器
 * @author liyibo
 * @date 2025-10-27 18:09
 */
@FunctionalInterface
public interface MetricTagSetter<T> {
    /**
     * 设置tag
     * @param result 业务方法的执行结果
     * @param initialTagMap 初始化后的tagMap，可以根据业务场景追加tag
     */
    void apply(T result, Map<MetricTag, String> initialTagMap);
}

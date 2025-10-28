package com.github.liyibo1110.pattern.proxy.metric;

/**
 * 监控流程中特有的异常封装
 * @author liyibo
 * @date 2025-10-27 18:06
 */
public class MetricException extends Exception {
    public MetricException(String message) {
        super(message);
    }
}

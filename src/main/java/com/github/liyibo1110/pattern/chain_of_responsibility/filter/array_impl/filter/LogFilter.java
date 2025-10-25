package com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;

/**
 * @author liyibo
 * @date 2025-10-24 17:43
 */
public class LogFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 前置操作
        System.out.println("log start...");
        // 直接放行到下一个Filter
        chain.doFilter(request, response);
        // 后置处理
        System.out.println("log end...");
    }
}

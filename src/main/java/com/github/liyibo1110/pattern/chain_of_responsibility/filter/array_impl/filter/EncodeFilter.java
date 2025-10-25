package com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liyibo
 * @date 2025-10-24 16:06
 */
public class EncodeFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 前置处理
        System.out.println("encode start...");
        // 随机拦截
        if(ThreadLocalRandom.current().nextInt(10) > 5)
            chain.doFilter(request, response);
        else {
            System.out.println("encodeFilter 终止...");
            return;
        }
        // 后置处理
        System.out.println("encode end...");
    }
}

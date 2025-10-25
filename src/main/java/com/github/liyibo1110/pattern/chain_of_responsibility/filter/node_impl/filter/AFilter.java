package com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.chain.FilterChain;

/**
 * @author liyibo
 * @date 2025-10-24 18:04
 */
public class AFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("AFilter");
        chain.doFilter(request, response);
    }
}

package com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.chain.FilterChain;

/**
 * @author liyibo
 * @date 2025-10-24 18:03
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

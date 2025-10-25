package com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;

/**
 * @author liyibo
 * @date 2025-10-24 16:03
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

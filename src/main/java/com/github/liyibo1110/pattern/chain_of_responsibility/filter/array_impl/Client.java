package com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Servlet;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter.EncodeFilter;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter.LogFilter;

/**
 * @author liyibo
 * @date 2025-10-24 16:03
 */
public class Client {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.addFilter(new LogFilter());
        chain.addFilter(new EncodeFilter());
        chain.setServlet(new Servlet());
        // 模拟1个请求
        chain.doFilter(new Request(), new Response());
    }
}

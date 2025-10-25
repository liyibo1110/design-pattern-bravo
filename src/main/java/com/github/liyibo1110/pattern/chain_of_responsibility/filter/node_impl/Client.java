package com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Servlet;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.chain.FilterChain;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter.AFilter;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter.BFilter;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter.CFilter;

/**
 * @author liyibo
 * @date 2025-10-24 18:03
 */
public class Client {
    public static void main(String[] args) {
        AFilter aFilter = new AFilter();
        BFilter bFilter = new BFilter();
        CFilter cFilter = new CFilter();

        // 业务1，注意a、b、c过滤器
        FilterChain chain1 = new FilterChain();
        chain1.addFilter(aFilter);
        chain1.addFilter(bFilter);
        chain1.addFilter(cFilter);
        chain1.setServlet(new Servlet());

        // 业务2、注入a和c过滤器
        FilterChain chain2 = new FilterChain();
        chain2.addFilter(aFilter);
        chain2.addFilter(bFilter);
        chain2.setServlet(new Servlet());

        chain1.doFilter(new Request(), new Response());
        chain1.doFilter(new Request(), new Response());
    }
}

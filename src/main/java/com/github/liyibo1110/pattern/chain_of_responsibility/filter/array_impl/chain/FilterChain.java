package com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.chain;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Servlet;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.array_impl.filter.Filter;

/**
 * 版本1：基于数组的filter
 * @author liyibo
 * @date 2025-10-24 16:03
 */
public class FilterChain {
    /** 执行目标 */
    private Servlet servlet;

    private Filter[] filters = new Filter[0];

    /** 记录该chain执行到了哪个filter */
    private int pos = 0;

    /** 记录添加的filter数量 */
    private int n = 0;

    public void doFilter(Request request, Response response) {
        if(this.pos < this.n) { // 先执行对应的过滤器
            Filter f = this.filters[this.pos++];
            f.doFilter(request, response, this);
        }else { // 直接执行servlet
            this.servlet.service(request, response);
        }
    }

    /**
     * 添加过滤器
     * @param filter
     */
    public void addFilter(Filter filter) {
        // 防止重复添加
        for(Filter f : this.filters) {
            if(f == filter)
                return;
        }
        // 尝试扩容
        if(this.n == this.filters.length) {
            Filter[] newFilters = new Filter[this.n + 10];
            System.arraycopy(this.filters, 0, newFilters, 0, n);
            this.filters = newFilters;
        }

        this.filters[this.n++] = filter;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}

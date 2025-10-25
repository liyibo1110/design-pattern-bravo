package com.github.liyibo1110.pattern.chain_of_responsibility.filter;

/**
 * @author liyibo
 * @date 2025-10-24 16:00
 */
public class Servlet {
    public void service(Request request, Response response) {
        System.out.println("执行了servlet.");
    }
}

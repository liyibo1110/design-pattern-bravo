package com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.chain;

import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Request;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Response;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.Servlet;
import com.github.liyibo1110.pattern.chain_of_responsibility.filter.node_impl.filter.Filter;

/**
 * 版本1：基于单向链表的filter
 * @author liyibo
 * @date 2025-10-24 18:05
 */
public class FilterChain {
    private Servlet servlet;

    /** 当前要执行的filter */
    private Node<Filter> current;

    public void doFilter(Request request, Response response) {
        if(this.current != null) {  // 还有filter要执行
            Filter f = this.current.getValue();
            this.current = this.current.getNext();
            f.doFilter(request, response, this);
        }else { // 没有filter或者都执行完了
            this.servlet.service(request, response);
        }
    }

    public void addFilter(Filter filter) {
        if(this.current == null)
            this.current = new Node<>(filter);
        else
            this.current.setNext(filter);
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return this.next;
        }

        /**
         * 在链表末尾追加Node
         * @param data
         */
        public void setNext(T data) {
            Node<T> newNode = new Node<>(data);
            Node<T> current = this;
            while(current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }
}

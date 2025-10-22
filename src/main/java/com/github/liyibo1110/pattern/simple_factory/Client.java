package com.github.liyibo1110.pattern.simple_factory;

import com.github.liyibo1110.pattern.simple_factory.product.AbstractProduct;

/**
 * @author liyibo
 * @date 2025-10-22 14:26
 */
public class Client {

    public void createProduct(String type) {
        AbstractProduct p = SimpleFactory.create(type);
        System.out.println(p);
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.createProduct("a");
    }
}

package com.github.liyibo1110.pattern.factory_method.pattern;

import com.github.liyibo1110.pattern.factory_method.pattern.factory.AbstractFactory;
import com.github.liyibo1110.pattern.factory_method.pattern.product.AbstractProduct;

/**
 * @author liyibo
 * @date 2025-10-22 15:06
 */
public class Client {

    private final AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public AbstractProduct createProduct() {
        return this.factory.create();
    }
}

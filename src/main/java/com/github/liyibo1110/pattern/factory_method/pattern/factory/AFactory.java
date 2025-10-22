package com.github.liyibo1110.pattern.factory_method.pattern.factory;

import com.github.liyibo1110.pattern.factory_method.pattern.product.AProduct;
import com.github.liyibo1110.pattern.factory_method.pattern.product.AbstractProduct;

/**
 * @author liyibo
 * @date 2025-10-22 15:05
 */
public class AFactory extends AbstractFactory {


    @Override
    public AbstractProduct create() {
        return new AProduct();
    }
}

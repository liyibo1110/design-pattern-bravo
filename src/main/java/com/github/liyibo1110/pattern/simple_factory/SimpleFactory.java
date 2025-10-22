package com.github.liyibo1110.pattern.simple_factory;

import com.github.liyibo1110.pattern.simple_factory.product.AProduct;
import com.github.liyibo1110.pattern.simple_factory.product.AbstractProduct;
import com.github.liyibo1110.pattern.simple_factory.product.BProduct;

/**
 * @author liyibo
 * @date 2025-10-22 14:23
 */
public class SimpleFactory {

    public static AbstractProduct create(String type) {
        if("a".equals(type))
            return new AProduct();
        else if("b".equals(type))
            return new BProduct();
        else
            throw new RuntimeException("产品类型错误");
    }
}

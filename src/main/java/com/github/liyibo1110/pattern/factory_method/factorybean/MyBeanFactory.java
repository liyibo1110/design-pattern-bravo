package com.github.liyibo1110.pattern.factory_method.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author liyibo
 * @date 2025-10-22 15:11
 */
@Component
public class MyBeanFactory implements FactoryBean<MyBean> {
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean("I'm from MyBeanFactory.");
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

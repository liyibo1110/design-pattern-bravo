package com.github.liyibo1110.pattern.factory_method.factorybean;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liyibo
 * @date 2025-10-22 16:40
 */
@SpringBootTest
public class MyBeanFactoryTest {
    @Resource
    private MyBean myBean1;

    @Resource(name="myBeanFactory")
    private MyBean myBean2;

    @Resource(name="&myBeanFactory")
    private MyBeanFactory myBeanFactory;

    @Test
    public void test() {
        System.out.println(myBean1);
        System.out.println(myBean2);
        System.out.println(myBeanFactory);
    }
}

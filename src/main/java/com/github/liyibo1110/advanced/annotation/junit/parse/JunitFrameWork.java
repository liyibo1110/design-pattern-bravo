package com.github.liyibo1110.advanced.annotation.junit.parse;

import com.github.liyibo1110.advanced.annotation.junit.define.After;
import com.github.liyibo1110.advanced.annotation.junit.define.Before;
import com.github.liyibo1110.advanced.annotation.junit.define.Test;
import com.github.liyibo1110.advanced.annotation.junit.use.UserTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-16 17:43
 */
public class JunitFrameWork {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = UserTest.class;
        Object obj = clazz.newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> beforeList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();
        for(Method method : methods) {
            if(method.isAnnotationPresent(Before.class))
                beforeList.add(method);
            else if(method.isAnnotationPresent(After.class))
                afterList.add(method);
            else if(method.isAnnotationPresent(Test.class))
                testList.add(method);
        }

        // 执行测试方法
        for(Method testMethod : testList) {
            // 执行@Before修饰的方法
            for(Method beforeMethod : beforeList) {
                beforeMethod.invoke(obj);
            }
            // 再执行@Test
            testMethod.invoke(obj);
            // 最后执行@After
            for(Method afterMethod : afterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}

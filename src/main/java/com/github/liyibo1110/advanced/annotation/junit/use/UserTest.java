package com.github.liyibo1110.advanced.annotation.junit.use;

import com.github.liyibo1110.advanced.annotation.junit.define.After;
import com.github.liyibo1110.advanced.annotation.junit.define.Before;
import com.github.liyibo1110.advanced.annotation.junit.define.Test;

/**
 * @author liyibo
 * @date 2025-10-16 17:41
 */
public class UserTest {
    @Before
    public void init() {
        System.out.println("初始化...");
    }

    @After
    public void destroy() {
        System.out.println("销毁...");
    }

    @Test
    public void testSave() {
        System.out.println("save...");
    }

    @Test
    public void testDelete() {
        System.out.println("delete...");
    }
}

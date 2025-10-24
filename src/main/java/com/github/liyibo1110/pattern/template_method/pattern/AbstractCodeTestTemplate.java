package com.github.liyibo1110.pattern.template_method.pattern;

/**
 * @author liyibo
 * @date 2025-10-23 17:30
 */
public abstract class AbstractCodeTestTemplate {

    public final void templateMethod() {
        long start = System.currentTimeMillis();
        this.executeCode(); // 不同子类有不同的实现
        long end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start));
    }

    protected abstract void executeCode();
}

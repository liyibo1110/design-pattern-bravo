package com.github.liyibo1110.pattern.factory_method.factorybean;

/**
 * @author liyibo
 * @date 2025-10-22 15:09
 */
public class MyBean {

    private final String message;

    public MyBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.github.liyibo1110.advanced.reflection.printclassinfo.clazz;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liyibo
 * @date 2025-10-17 11:50
 */
public class Son extends Father implements MyInterface<Integer, String>, Serializable {

    public String publicField;
    protected int protectedField;
    int defaultField;
    private int privateField;

    // 带注解的字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date annotatedField;

    public Son() {}

    public Son(int privateField) {
        this.privateField = privateField;
    }

    private Son(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    @Override
    public String interfaceMethod(Integer param) {
        return param.toString();
    }

    // 带泛型的方法
    @RequestMapping("/son/sonPrivateMethod")
    private void sonPrivateMethod(List<? extends Father> param) {
        System.out.println("Son私有方法, param:" + param);
    }

    @Override
    public String toString() {
        return "{" +
                "publicField='" + publicField + '\'' +
                ", protectedField=" + protectedField +
                ", defaultField=" + defaultField +
                ", privateField=" + privateField +
                ", annotatedField=" + annotatedField +
                "」";
    }
}

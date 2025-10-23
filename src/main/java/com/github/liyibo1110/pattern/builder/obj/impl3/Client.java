package com.github.liyibo1110.pattern.builder.obj.impl3;

/**
 * @author liyibo
 * @date 2025-10-23 11:10
 */
public class Client {

    public static void main(String[] args) {
        Product p = Product.builder()
                .step1("step 1")
                .step2("step 2")
                .step3("step 3")
                .build();
        System.out.println(p);
    }
}

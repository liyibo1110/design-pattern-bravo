package com.github.liyibo1110.pattern.builder.step.pattern;

/**
 * @author liyibo
 * @date 2025-10-23 14:00
 */
public class Client {
    public static void main(String[] args) {
        Product p = Product.builder()
                .step1("step1")
                .step2("step2")
                .step3("step3")
                .build();
        System.out.println(p);
    }
}

package com.github.liyibo1110.advanced.fluent.chain;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-20 10:22
 */
public class ChainCallByThis {

    public static void main(String[] args) {
        // 正常版本
        ChainCallByNew.Person p = new ChainCallByNew.Person().setName("张三").setAge(18).setMoney(1000D);
        System.out.println(p);
    }

    @Getter
    @ToString
    static class Person {
        private String name;
        private Integer age;
        private Double money;

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public Person setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Person setMoney(Double money) {
            this.money = money;
            return this;
        }
    }
}

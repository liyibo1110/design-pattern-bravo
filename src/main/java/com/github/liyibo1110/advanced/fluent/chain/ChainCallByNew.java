package com.github.liyibo1110.advanced.fluent.chain;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-20 10:20
 */
public class ChainCallByNew {

    public static void main(String[] args) {
        // 不建议，会生成过多的临时对象
        Person p = new Person().setName("张三").setAge(18).setMoney(1000D);
        System.out.println(p);
    }

    @Getter
    @ToString
    static class Person {
        private String name;
        private Integer age;
        private Double money;

        public Person() {

        }

        public Person(String name, Integer age, Double money) {
            this.name = name;
            this.age = age;
            this.money = money;
        }

        public Person setName(String name) {
            return new Person(name, this.age, this.money);
        }

        public Person setAge(Integer age) {
            return new Person(this.name, age, this.money);
        }

        public Person setMoney(Double money) {
            return new Person(this.name, this.age, money);
        }
    }
}

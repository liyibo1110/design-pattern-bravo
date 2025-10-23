package com.github.liyibo1110.pattern.builder.obj.impl1;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-23 10:30
 */
@Getter
@ToString
public class Student {

    private final String name;
    private final Integer age;
    private final String address;

    private Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(name, age, address);
        }
    }
}

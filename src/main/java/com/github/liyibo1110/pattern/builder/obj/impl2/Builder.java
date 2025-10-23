package com.github.liyibo1110.pattern.builder.obj.impl2;

/**
 * @author liyibo
 * @date 2025-10-23 11:04
 */
public class Builder {

    private String name;
    private Integer age;
    private String address;

    Builder() {}

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

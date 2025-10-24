package com.github.liyibo1110.pattern.singleton.impl6;

import lombok.Getter;

/**
 * 枚举单例
 * @author liyibo
 * @date 2025-10-23 15:55
 */
@Getter
public enum PersonEnum {

    STUDENT("张三", 18) {
        @Override
        public void jump() {
            System.out.println("张三跳");
        }
    };

    private final String name;
    private final Integer age;

    PersonEnum(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public abstract void jump();
}

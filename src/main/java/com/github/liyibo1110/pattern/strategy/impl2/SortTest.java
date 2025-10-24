package com.github.liyibo1110.pattern.strategy.impl2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liyibo
 * @date 2025-10-23 18:11
 */
public class SortTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 60, 160));
        list.add(new Person("李四", 58, 180));
        list.add(new Person("王五", 56, 170));
        // 按身高排序
        list.sort((o1, o2) -> o1.height - o2.height);
        // 再按年龄排序
        list.sort((o1, o2) -> o2.age - o1.age);
        System.out.println(list);
    }


    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
        private Integer height;
    }
}

package com.github.liyibo1110.pattern.strategy.impl1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liyibo
 * @date 2025-10-23 18:04
 */
public class SortTest {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 60, 160));
        list.add(new Person("李四", 58, 180));
        list.add(new Person("王五", 56, 170));
        list.sort();
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    static class Person implements Comparable<Person> {
        private String name;
        private Integer age;
        private Integer height;

        @Override
        public int compareTo(Person p) {
            return this.height - p.height;
        }
    }
}

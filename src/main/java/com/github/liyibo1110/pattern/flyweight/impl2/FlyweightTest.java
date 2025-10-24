package com.github.liyibo1110.pattern.flyweight.impl2;

import com.github.liyibo1110.pattern.flyweight.impl2.entity.Student;
import com.github.liyibo1110.pattern.flyweight.impl2.entity.Teacher;

/**
 * @author liyibo
 * @date 2025-10-23 17:13
 */
public class FlyweightTest {

    public static void main(String[] args) {
        new Student(1L, "学生1", "1号", "第一中学", "西城区", "努力学习");
        new Student(2L, "学生2", "2号", "第一中学", "西城区", "努力学习");
        new Student(3L, "学生3", "3号", "第二中学", "东城区", "好好学习");
        new Teacher(1L, "老师1", "1号", "第一中学", "西城区", "好好学习");
        new Teacher(2L, "老师2", "2号", "第一中学", "西城区", "好好学习");
    }
}

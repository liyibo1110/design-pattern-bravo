package com.github.liyibo1110.pattern.flyweight.impl2.entity;

import com.github.liyibo1110.pattern.flyweight.impl2.FlyweightFactory;

/**
 * @author liyibo
 * @date 2025-10-23 17:06
 */
public class Student {
    private Long id;
    private String name;
    private String studentNumber;
    private SchoolInfo schoolInfo;

    public Student(Long id, String name,
                   String studentNumber, String schoolName,
                   String schoolAddress, String schoolSlogan) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.schoolInfo = FlyweightFactory.getSchoolInfo(schoolName, schoolAddress, schoolSlogan);
    }
}

package com.github.liyibo1110.pattern.flyweight.impl2.entity;

import com.github.liyibo1110.pattern.flyweight.impl2.FlyweightFactory;

/**
 * @author liyibo
 * @date 2025-10-23 17:06
 */
public class Teacher {
    private Long id;
    private String name;
    private String course;
    private SchoolInfo schoolInfo;

    public Teacher(Long id, String name,
                   String course, String schoolName,
                   String schoolAddress, String schoolSlogan) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.schoolInfo = FlyweightFactory.getSchoolInfo(schoolName, schoolAddress, schoolSlogan);
    }
}

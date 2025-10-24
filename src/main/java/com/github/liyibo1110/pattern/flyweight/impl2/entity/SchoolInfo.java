package com.github.liyibo1110.pattern.flyweight.impl2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-23 17:06
 */
@Getter
@ToString
@AllArgsConstructor
public class SchoolInfo {
    private final String schoolName;

    private final String schoolAddress;

    private final String schoolSlogan;
}

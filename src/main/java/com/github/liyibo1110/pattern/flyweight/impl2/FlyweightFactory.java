package com.github.liyibo1110.pattern.flyweight.impl2;

import com.github.liyibo1110.pattern.flyweight.impl2.entity.SchoolInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyibo
 * @date 2025-10-23 17:07
 */
public class FlyweightFactory {

    private static final Map<String, SchoolInfo> SCHOOL_INFO_CACHE = new HashMap<>();

    private FlyweightFactory() {}

    public static SchoolInfo getSchoolInfo(String name, String address, String slogan) {
        String key = name + address + slogan;
        return SCHOOL_INFO_CACHE.computeIfAbsent(key, k -> new SchoolInfo(name, address, slogan));
    }

    public static void printCache() {
        System.out.println("SchoolInfo Cache: " + SCHOOL_INFO_CACHE);
    }
}

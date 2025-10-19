package com.github.liyibo1110.advanced.reflection.printclassinfo.clazz;

/**
 * @author liyibo
 * @date 2025-10-17 11:48
 */
@MyAnnotation("annotation on Father")
public class Father {

    private String fatherPrivateField;

    public String fatherPublicField;

    private String fatherPrivateMethod(String param) {
        return "";
    }

    public String fatherPublicMethod(String param) {
        return "";
    }
}

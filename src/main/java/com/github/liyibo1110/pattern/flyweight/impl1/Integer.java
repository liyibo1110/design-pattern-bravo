package com.github.liyibo1110.pattern.flyweight.impl1;

/**
 * @author liyibo
 * @date 2025-10-23 16:58
 */
public class Integer {

    private final int value;

    private static final Integer[] CACHE;

    static {
        CACHE = new Integer[256];
        // 缓存-128 ~ 127的对象，即为flyweight模式的一种复用体现
        for(int i = 0; i < CACHE.length ; i++)
            CACHE[i] = new Integer(i - 128);
    }

    private Integer(int value) {
        this.value = value;
    }

    public int intValue() {
        return this.value;
    }

    public static Integer valueOf(int value) {
        if(value >= -128 && value <= 127)
            return CACHE[value + 128];
        else
            return new Integer(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Integer)
            return value == ((Integer)obj).intValue();
        else
            return false;
    }
}

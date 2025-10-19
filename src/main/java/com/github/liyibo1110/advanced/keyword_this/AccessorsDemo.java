package com.github.liyibo1110.advanced.keyword_this;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author liyibo
 * @date 2025-10-16 14:10
 */
public class AccessorsDemo {

    public static void main(String[] args) {
        new Son().setSonName("son").setFatherName("father");
        // new Father().setFatherName("father").setSonName("son");
    }

    @Getter
    @Setter
    @Accessors(chain=true)
    static class Father {
        private String fatherName;
    }

    @Getter
    @Setter
    @Accessors(chain=true)
    static class Son extends Father {
        private String sonName;
    }
}

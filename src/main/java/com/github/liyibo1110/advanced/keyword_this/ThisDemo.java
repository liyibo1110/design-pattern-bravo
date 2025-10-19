package com.github.liyibo1110.advanced.keyword_this;

/**
 * @author liyibo
 * @date 2025-10-16 14:09
 */
public class ThisDemo {

    public static void main(String[] args) {
        Son son = new Son();
        Daughter daughter = new Daughter();
    }

    static class Father {
        public Father() {
            System.out.println(this.getClass().getName());
        }
    }

    static class Son extends Father {

    }

    static class Daughter extends Father {

    }
}

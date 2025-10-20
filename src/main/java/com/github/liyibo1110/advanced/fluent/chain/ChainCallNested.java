package com.github.liyibo1110.advanced.fluent.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liyibo
 * @date 2025-10-20 10:24
 */
public class ChainCallNested {

    public static void main(String[] args) {
        // 通过类嵌套形成的链式调用
        RussianDollBig russianDoll = queryRussianDoll();
        RussianDollSmall small = russianDoll.getMedium().getSmall();
        System.out.println(small);
    }

    private static RussianDollBig queryRussianDoll() {
        return new RussianDollBig(new RussianDollMedium(new RussianDollSmall("RussianDollSmall")));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollBig {
        private RussianDollMedium medium;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollMedium {
        private RussianDollSmall small;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollSmall {
        private final String name;
    }
}

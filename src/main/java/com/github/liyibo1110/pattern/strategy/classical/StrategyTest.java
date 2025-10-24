package com.github.liyibo1110.pattern.strategy.classical;

/**
 * @author liyibo
 * @date 2025-10-23 18:18
 */
public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context(new Add());

        int addResult = context.executeStrategy(2, 1);
        System.out.println("result:" + addResult);

        // 替换策略
        context.setStrategy(new Sub());
        int subResult = context.executeStrategy(2, 1);
        System.out.println("result:" + subResult);
    }
}

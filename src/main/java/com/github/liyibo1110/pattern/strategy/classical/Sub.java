package com.github.liyibo1110.pattern.strategy.classical;

/**
 * @author liyibo
 * @date 2025-10-23 18:17
 */
public class Sub implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

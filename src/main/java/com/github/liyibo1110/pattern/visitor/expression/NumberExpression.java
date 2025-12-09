package com.github.liyibo1110.pattern.visitor.expression;

/**
 * @author liyibo
 * @date 2025-12-08 11:33
 */
public class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return this.number;
    }
}

package com.github.liyibo1110.pattern.visitor.expression_print;

/**
 * @author liyibo
 * @date 2025-12-08 11:39
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

    @Override
    public String print() {
        return Integer.toString(this.number);
    }
}

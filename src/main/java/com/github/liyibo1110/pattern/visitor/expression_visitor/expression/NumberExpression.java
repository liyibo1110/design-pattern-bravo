package com.github.liyibo1110.pattern.visitor.expression_visitor.expression;

import com.github.liyibo1110.pattern.visitor.expression_visitor.visitor.Visitor;

/**
 * @author liyibo
 * @date 2025-12-08 11:49
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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

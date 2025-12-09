package com.github.liyibo1110.pattern.visitor.expression;

/**
 * @author liyibo
 * @date 2025-12-08 11:34
 */
public class AddExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}

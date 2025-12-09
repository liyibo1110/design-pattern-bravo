package com.github.liyibo1110.pattern.visitor.expression_print;

/**
 * @author liyibo
 * @date 2025-12-08 11:41
 */
public class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }

    @Override
    public String print() {
        return this.left.print() + "-" + this.right.print();
    }
}

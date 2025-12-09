package com.github.liyibo1110.pattern.visitor.expression_visitor.expression;

import com.github.liyibo1110.pattern.visitor.expression_visitor.visitor.Visitor;
import lombok.Getter;

/**
 * @author liyibo
 * @date 2025-12-08 11:51
 */
public class SubtractExpression implements Expression {
    @Getter
    private final Expression left;
    @Getter
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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

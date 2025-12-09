package com.github.liyibo1110.pattern.visitor.expression_visitor.visitor;

import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.AddExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.SubtractExpression;

/**
 * @author liyibo
 * @date 2025-12-08 11:56
 */
public class VisitorMath implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return this.sb.toString();
    }

    @Override
    public void visit(NumberExpression expression) {
        this.sb.append(expression.interpret());
    }

    @Override
    public void visit(AddExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("+");
        expression.getRight().accept(this);
    }

    @Override
    public void visit(SubtractExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("-");
        expression.getRight().accept(this);
    }
}

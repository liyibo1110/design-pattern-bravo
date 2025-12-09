package com.github.liyibo1110.pattern.visitor.expression_visitor.visitor;

import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.AddExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.SubtractExpression;

/**
 * @author liyibo
 * @date 2025-12-08 11:44
 */
public interface Visitor {
    void visit(NumberExpression expression);

    void visit(AddExpression expression);

    void visit(SubtractExpression expression);
}

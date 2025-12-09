package com.github.liyibo1110.pattern.visitor.expression_visitor.expression;

import com.github.liyibo1110.pattern.visitor.expression_visitor.visitor.Visitor;

/**
 * @author liyibo
 * @date 2025-12-08 11:44
 */
public interface Expression {
    int interpret();

    /**
     * 让相应的Expression实例，以指定的Visitor实例来进行访问操作
     * @param visitor 特定的访问者实例
     */
    void accept(Visitor visitor);
}

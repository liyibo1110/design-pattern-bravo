package com.github.liyibo1110.pattern.visitor.expression_print;

/**
 * @author liyibo
 * @date 2025-12-08 11:37
 */
public interface Expression {
    int interpret();
    String print();
}

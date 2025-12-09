package com.github.liyibo1110.pattern.visitor.expression;

/**
 * @author liyibo
 * @date 2025-12-08 11:33
 */
public class Test {
    public static void main(String[] args) {
        Expression expression = new SubtractExpression(
            new AddExpression(new NumberExpression(1), new NumberExpression(2)),
            new NumberExpression(3)
        );
        int result = expression.interpret();
        System.out.println(result); // 最终输出0
    }
}

package com.github.liyibo1110.pattern.visitor.expression_visitor.visitor;

import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.AddExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.SubtractExpression;

/**
 * @author liyibo
 * @date 2025-12-08 11:56
 */
public class VisitorChinese implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return this.sb.toString();
    }
    @Override
    public void visit(NumberExpression expression) {
        int num = expression.interpret();
        String[] chineseDigits = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        char[] digits = String.valueOf(num).toCharArray();
        for(char digit : digits)
            this.sb.append(chineseDigits[Character.getNumericValue(digit)]);
    }

    @Override
    public void visit(AddExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("加");
        expression.getRight().accept(this);
    }

    @Override
    public void visit(SubtractExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("减");
        expression.getRight().accept(this);
    }
}

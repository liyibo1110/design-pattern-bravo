package com.github.liyibo1110.pattern.visitor.expression_visitor.visitor;

import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.AddExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.github.liyibo1110.pattern.visitor.expression_visitor.expression.SubtractExpression;

/**
 * @author liyibo
 * @date 2025-12-08 11:56
 */
public class VisitorJapanese implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return this.sb.toString();
    }

    @Override
    public void visit(NumberExpression expression) {
        int num = expression.interpret();
        String[] japaneseDigits = {"れい", "いち", "に", "さん", "よん", "ご", "ろく", "しち", "はち", "きゅう"};
        char[] digits = String.valueOf(num).toCharArray();
        for(char digit : digits)
            this.sb.append(japaneseDigits[Character.getNumericValue(digit)]);
    }

    @Override
    public void visit(AddExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("足す");
        expression.getRight().accept(this);
    }

    @Override
    public void visit(SubtractExpression expression) {
        expression.getLeft().accept(this);
        this.sb.append("引く");
        expression.getRight().accept(this);
    }
}

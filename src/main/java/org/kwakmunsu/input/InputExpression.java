package org.kwakmunsu.input;

import java.util.Scanner;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.separator.ExpressionSeparator;

public class InputExpression {

    private final ExpressionSeparator expressionSeparator;

    public InputExpression() {
        this.expressionSeparator = new ExpressionSeparator();
    }

    public Expression createExpression() {
        Scanner sc = new Scanner(System.in);
        String[] expression = sc.nextLine().split(" ");
        validateNUllOrEmpty(expression);
        return expressionSeparator(expression);
    }

    private Expression expressionSeparator(String[] expression) {
        // 가독성을 위해서 따로 할당함.
        String operands = expression[0];
        String operator = expression[1];
        return expressionSeparator.separateExpression(operands, operator);
    }

    // 수식의 유효성 검증은 expression 를 만들어낸  이 클래스에서 책임져줘야 생각했음.
    private void validateNUllOrEmpty(String[] expression) {
        if (expression == null) {
            throw new NullPointerException(ErrorMessage.INVALID_NULL.getMessage());
        } else if (expression.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.NO_SUCH_ELEMENT.getMessage());
        }
    }

}
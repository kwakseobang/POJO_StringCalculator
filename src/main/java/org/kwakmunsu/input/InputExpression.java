package org.kwakmunsu.input;

import java.util.Scanner;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.separator.ExpressionSeparator;

public class InputExpression {

    private final ExpressionSeparator expressionSeparator;
    private static final int MIN_EXPRESSION_LENGTH = 2;
    private static final String EMPTY_CHAR = " ";

    public InputExpression() {
        this.expressionSeparator = new ExpressionSeparator();
    }

    public Expression createExpression() {
        Scanner sc = new Scanner(System.in);
        String[] expression = sc.nextLine().split(EMPTY_CHAR);
        validateMinExpressionLength(expression);
        return expressionSeparator(expression);
    }

    private Expression expressionSeparator(String[] expression) {
        // 가독성을 위해서 따로 할당함.
        String operands = expression[0];
        String operator = expression[1];
        // 구현이 아니라 단순 메시지 전달이라 생각하여 단일 책임 원칙이 지켜졌다고 생각함.
        return expressionSeparator.separateExpression(operands, operator);
    }

    // 수식의 유효성 검증은 expression 를 만들어낸 이 클래스에서 책임져줘야 생각했음.
    private void validateMinExpressionLength(String[] expression) {
        if (expression.length != MIN_EXPRESSION_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MIN_INPUT_EXPRESSION.getMessage());
        }
    }

}
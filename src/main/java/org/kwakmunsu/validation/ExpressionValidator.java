package org.kwakmunsu.validation;

import org.kwakmunsu.Input.ExpressionData;
import org.kwakmunsu.error.ErrorMessage;

public class ExpressionValidator {

    private ExpressionValidator() {
    }

    private static final String OPERAND_SEPARATOR = "^[0-9]+([,:][0-9]+)*$";
    private static final String OPERATOR_SEPARATOR = "[+\\-*/]";

    public static void validateExpression(ExpressionData expressionData) {
        validateExpressionData(expressionData);
        validateOperand(expressionData.operand());
        validateOperator(expressionData.operator());
    }

    public static void checkForZeroDivision(int num, String operator) throws ArithmeticException {
        if (num == 0 && operator.equals("/")) {
            throw new ArithmeticException(ErrorMessage.ZERO_DIVISION.getMessage());
        }
    }

    private static void validateExpressionData(ExpressionData expressionData) {
        if (expressionData == null) {
            throw new NullPointerException(ErrorMessage.INVALID_NULL.getMessage());
        }
    }

    private static void validateOperand(String operand) {
        if (!operand.matches(OPERAND_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
        }
    }

    private static void validateOperator(String operator) {
        if (!operator.matches(OPERATOR_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
        }
    }

}
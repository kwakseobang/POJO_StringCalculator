package org.kwakmunsu.operation;

import java.util.function.DoubleBinaryOperator;
import org.kwakmunsu.error.ErrorMessage;

public enum Operation {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> {
        validateDivision(y);
        return x / y;
    });

    private final String operator;
    private final DoubleBinaryOperator operation;

    Operation(String operator, DoubleBinaryOperator operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operation getOperation(String operator) {
        for (Operation operation : Operation.values()) {
            if (operation.operator.equals(operator)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
    }

    public double calculate(String[] operands) {
        double result = 0.0;
        for (String operand : operands) {
            result = operation.applyAsDouble(result, Double.parseDouble(operand));
        }
        return Double.parseDouble(String.format("%.1f", result));
    }

    private static void validateDivision(double secOperand) {
        if (secOperand == 0) {
            throw new ArithmeticException(ErrorMessage.ZERO_DIVISION.getMessage());
        }
    }

}
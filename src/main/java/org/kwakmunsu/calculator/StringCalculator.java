package org.kwakmunsu.calculator;

import java.util.Queue;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.validation.ExpressionValidator;

public class StringCalculator {

    public String calculateExpression(Queue<Integer> operandQueue, String operator) {
        if (operandQueue == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NULL.getMessage());
        }
        double result = operandQueue.poll();
        while (!operandQueue.isEmpty()) {
            result = operation(result, operandQueue.poll(), operator);
        }
        return String.format("%.1f", result);
    }

    private double operation(double firstNum, int secNum, String op) {
        if (op.equals("/")) {
            ExpressionValidator.checkForZeroDivision(secNum, op);
        }
        return switch (op) {
            case "+" -> firstNum + secNum;
            case "-" -> firstNum - secNum;
            case "*" -> firstNum * secNum;
            case "/" -> firstNum / secNum;
            default -> 0.0;
        };
    }

}
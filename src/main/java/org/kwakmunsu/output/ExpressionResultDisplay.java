package org.kwakmunsu.output;

import java.util.stream.IntStream;
import org.kwakmunsu.input.Expression;

public class ExpressionResultDisplay {

    private static int printNum = 1;
    private final StringBuilder stringBuilder;
    private int lastOperandsIndex = 0;

    public ExpressionResultDisplay() {
        this.stringBuilder = new StringBuilder();
    }

    public void resultPrinter(Expression expression, double result) {
        expressionAppender(expression.operands(), expression.operator());
        appendResultValue(result);
        System.out.println(stringBuilder);
    }

    private void expressionAppender(String[] operands, String operator) {
        lastOperandsIndex = operands.length - 1;

        stringBuilder.append(printNum++).append(".").append(" ");
        IntStream.range(0, operands.length).forEach(i -> {
            stringBuilder.append(operands[i]).append(" ");
            if (isNotLastOperand(i)) {
                stringBuilder.append(operator).append(" ");
            } else {
                stringBuilder.append("= ");
            }
        });
    }

    private void appendResultValue(double result) {
        if (result % 1 == 0.0) {
            stringBuilder.append((int) result).append("\n"); // result == n.0 일경우 int 형 변환
        } else {
            stringBuilder.append(result).append("\n");
        }
    }

    private boolean isNotLastOperand(int index) {
        return index != lastOperandsIndex;
    }
}
package org.kwakmunsu;

import java.util.stream.IntStream;
import org.kwakmunsu.OutPut.CalculateResult;

public class ExpressionResultDisplay {

    private final StringBuilder stringBuilder;

    public ExpressionResultDisplay() {
        this.stringBuilder = new StringBuilder();
    }

    public void resultPrinter() {
        System.out.println(stringBuilder);
    }

    public void resultAppender(CalculateResult calculateResult) {
        stringBuilder.append(calculateResult.printNum()).append(".").append(" ");
        appendOperandsAndOperator(calculateResult.parsedOperand(), calculateResult.operator());
        appendResultValue(calculateResult.result());
    }

    private void appendOperandsAndOperator(String[] operands, String operator) {
        IntStream.range(0, operands.length).forEach(i -> {
            stringBuilder.append(operands[i]).append(" ");
            if (i == operands.length - 1) {
                stringBuilder.append("=").append(" ");
            } else {
                stringBuilder.append(operator).append(" ");
            }
        });
    }

    private void appendResultValue(double result) {
        if (result % 1 == 0.0) {
            stringBuilder.append((int) result).append("\n"); // result == n.0 일경우 정수 형변환
        } else {
            stringBuilder.append(result).append("\n");
        }
    }

}


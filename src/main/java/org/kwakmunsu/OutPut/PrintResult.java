package org.kwakmunsu.OutPut;

import java.util.stream.IntStream;

public class PrintResult {

    private final StringBuilder stringBuilder;

    public PrintResult() {
        this.stringBuilder = new StringBuilder();
    }

    public void resultPrinter() {
        System.out.println(stringBuilder);
    }

    public void resultAppender(String[] parsedOperand, String operator, double result,
        int printNum) {
        stringBuilder.append(printNum).append(".").append(" ");
        appendOperandsAndOperator(parsedOperand, operator);
        appendResultValue(result);
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
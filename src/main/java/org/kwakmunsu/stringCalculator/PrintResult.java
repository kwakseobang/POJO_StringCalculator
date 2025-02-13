package org.kwakmunsu.stringCalculator;

import java.util.stream.IntStream;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;

public class PrintResult {

    private  StringBuilder stringBuilder;

    private InputStringParser inputStringParser;

    public PrintResult(StringBuilder stringBuilder, InputStringParser inputStringParser) {
        this.stringBuilder = stringBuilder;
        this.inputStringParser = inputStringParser;
    }

    public void printAppender(double result,String operand,String operator,int printNum) {
        String[] nums = operandParser(operand);
        stringBuilder.append(printNum+". ");
        IntStream.range(0,nums.length).forEach(i -> {
                    stringBuilder.append(nums[i]+" ");
                    boolean isLast = (i == nums.length - 1);
                    stringBuilder.append(isLast ? "=" : operator).append(" ");
                });
        stringBuilder.append(result % 1 == 0 ? (int)result : result).append("\n"); // n.0 일경우 정수 형변환
    }

    private String[] operandParser(String operand) {
        return inputStringParser.operandParser(operand);
    }

    public void resultPrinter() {
        System.out.println(stringBuilder);
    }

}

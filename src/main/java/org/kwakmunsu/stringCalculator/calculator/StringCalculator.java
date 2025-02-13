package org.kwakmunsu.stringCalculator.calculator;

import java.util.Queue;
import org.kwakmunsu.stringCalculator.ArrayConverter;
import org.kwakmunsu.stringCalculator.PrintResult;
import org.kwakmunsu.stringCalculator.error.response.ErrorMessage;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;
import org.kwakmunsu.stringCalculator.validation.InputStringValidator;
import org.kwakmunsu.stringCalculator.validation.ZeroDivisionValidator;

public class StringCalculator {
    private String operand;
    private String operator;
    private InputStringParser inputStringParser;
    private InputStringValidator inputStringValidator;
    private ZeroDivisionValidator zeroDivisionValidator;

    public StringCalculator(
            InputStringParser inputStringParser,
            InputStringValidator inputStringValidator,
            ZeroDivisionValidator zeroDivisionValidator
            ) {
        this.inputStringParser = inputStringParser;
        this.inputStringValidator = inputStringValidator;
        this.zeroDivisionValidator = zeroDivisionValidator;
    }
    public int calculateString(
            String operand,
            String operator
    )throws IllegalArgumentException,ArithmeticException  {
        validateString(operand, operator);

        this.operand = operand;
        this.operator = operator;

        String[] nums = operandParser();

        return calculator(convertToQueue(nums),operator);
    }
    private String[] operandParser() {
        return inputStringParser.operandParser(operand);
    }
    private void validateString(String operand, String operator) throws IllegalArgumentException {
        inputStringValidator.validateString(operand, operator);

    }
    private int calculator(Queue<Integer> nums, String op)throws ArithmeticException {
        int result = nums.poll();
        while (!nums.isEmpty()) {
            result = cal(result,nums.poll(),op);
        }
        return result;
    }
    private int cal(int firstNum,int secNum,String op) throws ArithmeticException{
            checkForZeroDivision(secNum, op);

            switch (op) {
            case "+":
                return firstNum + secNum;
            case "-":
                return firstNum - secNum;
            case "*":
                return firstNum * secNum;
            case "/":
                return firstNum / secNum;
            default:
                return 0;
        }
    }
    private void checkForZeroDivision(int num, String op) throws ArithmeticException{
        zeroDivisionValidator.checkForZeroDivision(num,op);
    }
    private Queue<Integer> convertToQueue(String[] nums) {
        return ArrayConverter.convertStringArrayToIntegerQueue(nums);
    }
}

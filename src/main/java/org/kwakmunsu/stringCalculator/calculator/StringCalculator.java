package org.kwakmunsu.stringCalculator.calculator;

import java.util.Queue;
import org.kwakmunsu.stringCalculator.ArrayConverter;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;
import org.kwakmunsu.stringCalculator.validation.InputStringValidator;
import org.kwakmunsu.stringCalculator.validation.ZeroDivisionValidator;

public class StringCalculator {

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

    public double calculateString(
            String operand,
            String operator
    )throws IllegalArgumentException,ArithmeticException  {

        validateString(operand, operator);

        String[] nums = operandParser(operand);

        Queue<Integer> numsQueue = convertToQueue(nums);

        return calculator(numsQueue,operator);
    }

    private String[] operandParser(String operand) {
        return inputStringParser.operandParser(operand);
    }

    private void validateString(String operand, String operator) throws IllegalArgumentException {
        inputStringValidator.validateString(operand, operator);
    }

    private double calculator(Queue<Integer> nums, String op) throws ArithmeticException {
        double result = nums.poll();
        while (!nums.isEmpty()) {
            result = operation(result,nums.poll(),op);
        }
        return Math.round(result * 10.0) / 10.0;
    }

    private double operation(double firstNum,int secNum,String op) throws ArithmeticException{

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
                return 0.0;
        }
    }

    private void checkForZeroDivision(int num, String op) throws ArithmeticException{
        zeroDivisionValidator.checkForZeroDivision(num,op);
    }

    private Queue<Integer> convertToQueue(String[] nums) {
        return ArrayConverter.convertStringArrayToIntegerQueue(nums);
    }
}

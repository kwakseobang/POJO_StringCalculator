package org.kwakmunsu;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.SortedMap;
import org.kwakmunsu.Input.ExpressionData;
import org.kwakmunsu.Input.InputExpression;
import org.kwakmunsu.OutPut.PrintResult;
import org.kwakmunsu.calculator.StringCalculator;
import org.kwakmunsu.error.ExitException;
import org.kwakmunsu.parser.OperandParser;
import org.kwakmunsu.util.ArrayConverter;
import org.kwakmunsu.validation.ExpressionValidator;

public class Main {

    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();
        InputExpression inputExpression = new InputExpression();
        PrintResult printResult = new PrintResult();
        int printNum = 1;

        while (true) {
            try {
                ExpressionData expressionData = inputExpression.input();
                ExpressionValidator.validateExpression(expressionData);
                String[] parsedOperand = OperandParser.splitOperand(expressionData.operand());
                Queue<Integer> operandQueue = ArrayConverter.toIntegerQueue(parsedOperand);
                printResult.resultAppender(parsedOperand, expressionData.operator(),
                    Double.parseDouble(stringCalculator.calculateExpression(operandQueue,
                        expressionData.operator())),
                    printNum++
                );
            } catch (IOException | IllegalArgumentException | ArithmeticException |
                     NoSuchElementException | NullPointerException ex) {
                System.out.println(ex.getMessage());
                break;
            } catch (ExitException ex) {
                break;
            }
        }
        printResult.resultPrinter();
    }

}
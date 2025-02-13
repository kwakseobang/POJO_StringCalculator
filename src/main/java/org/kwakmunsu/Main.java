package org.kwakmunsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;
import org.kwakmunsu.stringCalculator.PrintResult;
import org.kwakmunsu.stringCalculator.calculator.StringCalculator;
import org.kwakmunsu.stringCalculator.error.ErrorMessage;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;
import org.kwakmunsu.stringCalculator.validation.InputStringValidator;
import org.kwakmunsu.stringCalculator.validation.ZeroDivisionValidator;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStringParser inputStringParser = new InputStringParser();
        InputStringValidator inputStringValidator = new InputStringValidator();
        ZeroDivisionValidator zeroDivisionValidator = new ZeroDivisionValidator();
        StringCalculator stringCalculator = new StringCalculator(
                inputStringParser,
                inputStringValidator,
                zeroDivisionValidator
        );

        String operand = "";
        String operator = "";
        int printNum = 1;
        PrintResult printResult = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            // 입력
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                operand = stringTokenizer.nextToken();
                if (operand.equals("q"))
                    break;
                operator = stringTokenizer.nextToken();
                // 계산 후 출력 저장
                printResult = new PrintResult(stringBuilder, inputStringParser);
                printResult.printAppender(
                        stringCalculator.calculateString(operand, operator),
                        operand,
                        operator,
                        printNum
                );
                printNum++;
            } catch (IllegalArgumentException | ArithmeticException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ErrorMessage.EXIT);
                break;
            }
        }
        // 출력
        printResult.resultPrinter();

    }

}
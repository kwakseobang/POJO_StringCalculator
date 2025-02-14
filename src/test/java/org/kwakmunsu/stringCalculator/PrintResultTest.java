package org.kwakmunsu.stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;

class PrintResultTest {
    private StringBuilder stringBuilder;
    private InputStringParser inputStringParser;
    private PrintResult printResult;

    @BeforeEach
    void setUp() {
        stringBuilder = new StringBuilder();
        inputStringParser = new InputStringParser();
        printResult = new PrintResult(stringBuilder,inputStringParser);
    }

    @Test
    @DisplayName("연산 결과 추가 테스트")
    void printAppender() {
        // given
        String operand = "23:4";
        String operator= "+";
        double result = 27.0;
        int printNum = 1;

        String operand2 = "4,2:5";
        String operator2= "/";
        double result2 = 0.4;
        int printNum2 = 2;

        //when
        printResult.printAppender(result,operand,operator,printNum);
        printResult.printAppender(result2,operand2,operator2,printNum2);

        // then
        assertThat(stringBuilder.toString()).isEqualTo("1. 23 + 4 = 27\n2. 4 / 2 / 5 = 0.4\n");
    }
}
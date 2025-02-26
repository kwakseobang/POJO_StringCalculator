package org.kwakmunsu.Output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.OutPut.PrintResult;

class PrintResultTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintResult printResult;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // System.out 가로채기
        printResult = new PrintResult();
    }

    @Test
    void 연산_결과_추가_테스트() {
        // given
        String[] operand = {"42", "21", "5"};
        String operator = "+";
        double result = 68.0;
        int printNum = 1;

        String[] operand2 = {"4", "2", "5"};
        String operator2 = "/";
        double result2 = 0.4;
        int printNum2 = 2;

        //when
        printResult.resultAppender(operand, operator, result, printNum);
        printResult.resultAppender(operand2, operator2, result2, printNum2);
        printResult.resultPrinter();
        // then
        assertThat(outputStreamCaptor.toString().trim())
            .isEqualTo(
                "1. 42 + 21 + 5 = 68\n2. 4 / 2 / 5 = 0.4");
    }
}
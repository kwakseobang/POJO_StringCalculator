package org.kwakmunsu.output;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.input.Expression;

class PrintResultTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ExpressionResultDisplay display;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // System.out 가로채기
        display = new ExpressionResultDisplay();
    }

    @Test
    void 연산_결과_추가_테스트() {
        // given
        String operator = "+";
        String[] operands = {"3", "2", "4"};
        Expression expression = new Expression(operands, operator);
        double result1 = 9;

        //when
        display.resultPrinter(expression, result1);

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1. 3 + 2 + 4 = 9");
    }

}
package org.kwakmunsu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.calculator.StringCalculator;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.parser.OperandParser;
import org.kwakmunsu.util.ArrayConverter;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 정상_구문_작동_테스트() {
        // given
        String operator = "/";
        Queue<Integer> operandQueue = new LinkedList<>(Arrays.asList(10, 20, 30));
        // when
        String result = stringCalculator.calculateExpression(operandQueue, operator);
        // then
        assertThat(result).isEqualTo("0.7");
    }

    @Test
    void 연산자_연산_테스트() {
        // given
        Queue<Integer> firstOperandQueue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> secOperandQueue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> thirdOperandQueue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> fourthOperandQueue = new LinkedList<>(Arrays.asList(60, 20, 30));
        Queue<Integer> fifthOperandQueue = new LinkedList<>(Arrays.asList(8, 3, 2));
        // when & then
        assertThat(stringCalculator.calculateExpression(firstOperandQueue, "+")).isEqualTo("60.0");
        assertThat(stringCalculator.calculateExpression(secOperandQueue, "-")).isEqualTo("-40.0");
        assertThat(stringCalculator.calculateExpression(thirdOperandQueue, "*")).isEqualTo(
            "6000.0");
        assertThat(stringCalculator.calculateExpression(fourthOperandQueue, "/")).isEqualTo("0.1");
        assertThat(stringCalculator.calculateExpression(fifthOperandQueue, "/")).isEqualTo("1.3");
    }

    @Test
    void null_값_처리_테스트() {
        // given
        Queue<Integer> operandQueue = null;
        String operator = "/";
        // when & then
        assertThatThrownBy(() -> stringCalculator.calculateExpression(operandQueue, operator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NULL.getMessage());
    }

}
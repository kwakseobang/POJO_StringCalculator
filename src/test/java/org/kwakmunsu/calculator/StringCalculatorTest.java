package org.kwakmunsu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.input.Expression;

class StringCalculatorTest {

    private ExpressionCalculator expressionCalculator;

    @BeforeEach
    void setUp() {
        expressionCalculator = new ExpressionCalculator();
    }

    @Test
    void 정상_구문_작동_테스트() {
        // given
        String operator = "+";
        String[] operands = {"3", "2", "4"};
        Expression expression = new Expression(operands, operator);
        // when
        double result = expressionCalculator.calculateExpression(expression);
        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 제로나누기_예외_확인_테스트() {
        // given
        String operator = "/";
        String[] operands = {"3", "0", "4"};
        Expression expression = new Expression(operands, operator);
        // when & then
        assertThatThrownBy(() -> expressionCalculator.calculateExpression(expression))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage(ErrorMessage.ZERO_DIVISION.getMessage());
    }

}
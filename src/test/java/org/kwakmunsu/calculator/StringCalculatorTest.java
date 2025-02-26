package org.kwakmunsu.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

}
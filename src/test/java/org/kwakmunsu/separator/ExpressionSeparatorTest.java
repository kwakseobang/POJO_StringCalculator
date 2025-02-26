package org.kwakmunsu.parser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.Input.Expression;
import org.kwakmunsu.Separator.ExpressionSeparator;

class ExpressionSeparatorTest {

    private ExpressionSeparator expressionSeparator;

    @BeforeEach
    void setUp() {
        expressionSeparator = new ExpressionSeparator();
    }

    @Test
    void 수식_정상작동_테스트() {
        // given
        String operator = "+";
        String operand = "3,2:4";
        String[] operands = {"3", "2", "4"};
        Expression expression = new Expression(operands, operator);

        // when & then
        assertThat(expressionSeparator.separateExpression(operand, operator)).isEqualTo(expression);
    }

}
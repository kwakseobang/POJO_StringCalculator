package org.kwakmunsu.separator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.input.Expression;

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

        // when
        Expression expression = expressionSeparator.separateExpression(operand, operator);

        // then
        assertThat(expression.operands()).isEqualTo(operands);
        assertThat(expression.operator()).isEqualTo(operator);
    }

}
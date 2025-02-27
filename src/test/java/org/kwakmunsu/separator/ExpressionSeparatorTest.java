package org.kwakmunsu.separator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.error.ErrorMessage;
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

    @Test
    void 연산자_예외_확인_테스트() {
        // given
        String operand1 = "4,2:1";
        String operator1 = "a";
        String operand2 = "4:2";
        String operator2 = "* ";
        String operand3 = "9,2";
        String operator3 = " +";
        String operand4 = "9,2";
        String operator4 = "";
        String operand5 = "9,2";
        String operator5 = " ";

        // when & then
        assertSoftly(softly -> {
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand1, operator1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
            softly.assertThatThrownBy(
                    () -> expressionSeparator.separateExpression(operand2, operator2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
            softly.assertThatThrownBy(
                    () -> expressionSeparator.separateExpression(operand3, operator3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
            softly.assertThatThrownBy(
                    () -> expressionSeparator.separateExpression(operand4, operator4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
            softly.assertThatThrownBy(
                    () -> expressionSeparator.separateExpression(operand5, operator5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
            }
        );
    }

    @Test
    void 피연산자_예외_확인_테스트() {
        // given
        String operand1 = "4:,2:1";
        String operator1 = "+";
        String operand2 = "4:2,";
        String operator2 = "*";
        String operand3 = " ";
        String operator3 = "+";
        String operand4 = ":23,2";
        String operator4 = "/";
        String operand5 = "a,2";
        String operator5 = "/";

        // when & then
        assertSoftly(softly -> {
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand1, operator1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand2, operator2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand3, operator3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand4, operator4))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
                softly.assertThatThrownBy(
                        () -> expressionSeparator.separateExpression(operand5, operator5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
            }
        );
    }

}
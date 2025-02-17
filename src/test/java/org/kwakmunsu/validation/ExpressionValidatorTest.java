package org.kwakmunsu.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Test;
import org.kwakmunsu.Input.ExpressionData;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.validation.ExpressionValidator;

class ExpressionValidatorTest {

    @Test
    void 정상_구문_작동_테스트() {
        // given
        ExpressionData[] validExpressions = {
            new ExpressionData("4:2:1", "+"),
            new ExpressionData("4:2,1", "*"),
            new ExpressionData("2:1,3", "+"),
            new ExpressionData("12:2:4", "/")
        };
        // when & then
        for (ExpressionData data : validExpressions) {
            assertThatCode(() -> ExpressionValidator.validateExpression(data))
                .doesNotThrowAnyException();
        }
    }

    @Test
    void 피연산자_예외_확인_테스트() {
        // given
        ExpressionData[] validExpressions = {
            new ExpressionData("4:,2:1", "+"),
            new ExpressionData("4:2,", "*"),
            new ExpressionData(" ", "+"),
            new ExpressionData(":23,2", "/"),
            new ExpressionData("a,2", "/")
        };
        // when & then
        assertSoftly(softly -> {
                for (ExpressionData data : validExpressions) {
                    softly.assertThatThrownBy(() -> ExpressionValidator.validateExpression(data))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
                }
            }
        );
    }

    @Test
    void 연산자_예외_확인_테스트() {
        // given
        ExpressionData[] validExpressions = {
            new ExpressionData("4,2:1", "a"),
            new ExpressionData("4:2", "* "),
            new ExpressionData("9:2", " +"),
            new ExpressionData("23,2", ""),
            new ExpressionData("23,2", " "),
            new ExpressionData("23,2", "/*")
        };
        // when & then
        assertSoftly(softly -> {
                for (ExpressionData data : validExpressions) {
                    softly.assertThatThrownBy(() -> ExpressionValidator.validateExpression(data))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
                }
            }
        );
    }

    @Test
    void 제로나누기_예외_확인_테스트() {
        // given
        int zero = 0;
        int num = 5;
        // when & then
        assertThatThrownBy(() -> ExpressionValidator.checkForZeroDivision(zero,"/"))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage(ErrorMessage.ZERO_DIVISION.getMessage());
    }

}
package org.kwakmunsu.stringCalculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.stringCalculator.PrintResult;
import org.kwakmunsu.stringCalculator.error.ErrorMessage;
import org.kwakmunsu.stringCalculator.parser.InputStringParser;
import org.kwakmunsu.stringCalculator.validation.InputStringValidator;
import org.kwakmunsu.stringCalculator.validation.ZeroDivisionValidator;

class StringCalculatorTest {

    private InputStringParser inputStringParser;
    private InputStringValidator inputStringValidator;
    private ZeroDivisionValidator zeroDivisionValidator;
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        inputStringParser = new InputStringParser();
        inputStringValidator = new InputStringValidator();
        zeroDivisionValidator = new ZeroDivisionValidator();
        stringCalculator = new StringCalculator(inputStringParser,inputStringValidator,zeroDivisionValidator);
    }

    @Test
    void 문자열_계산_정상작동_테스트() {
        // given
        String operand = "10,3,5";
        String operator = "/";

        // when
       double result = stringCalculator.calculateString(operand,operator);

        // then
        assertThat(result).isEqualTo(0.7);
    }

    @Test
    void 문자열_계산_예외_테스트() {
        // given
        String operand1 = "4,22:a";
        String operator1 = "/";

        String operand2 = "";
        String operator2 = "/";

        String operand3 = ",422";
        String operator3 = "/";

        String operand4 = "4,22";
        String operator4 = "";

        String operand5 = "40:0:1:0";
        String operator5 = "/";

        // when & then
        assertSoftly( softly -> {
                    softly.assertThatThrownBy(() -> stringCalculator.calculateString(operand1, operator1))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

                    softly.assertThatThrownBy(() -> stringCalculator.calculateString(operand2, operator2))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

                    softly.assertThatThrownBy(() -> stringCalculator.calculateString(operand3, operator3))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

                    softly.assertThatThrownBy(() -> stringCalculator.calculateString(operand4, operator4))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR);

                    softly.assertThatThrownBy(() -> stringCalculator.calculateString(operand5, operator5))
                            .isInstanceOf(ArithmeticException.class)
                            .hasMessage(ErrorMessage.ZERO_DIVISION);
                }
        );
    }
}
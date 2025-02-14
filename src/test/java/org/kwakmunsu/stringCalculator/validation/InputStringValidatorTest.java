package org.kwakmunsu.stringCalculator.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.stringCalculator.error.ErrorMessage;

class InputStringValidatorTest {

    private InputStringValidator inputStringValidator;

    @BeforeEach
    void setUp() {
        inputStringValidator = new InputStringValidator();
    }

    @Test
    void 정상_구문_작동_테스트() {
        //given
        String opreand1 = "4:2:1";
        String operator1 = "+";
        String opreand2 = "4:2,1";
        String operator2 = "*";
        String opreand3 = "2:1,3";
        String operator3 = "+";
        String opreand4 = "12:2:4";
        String operator4 = "/";

        // when & then
        assertThatCode(() -> inputStringValidator.validateString(opreand1, operator1))
                .doesNotThrowAnyException();
        assertThatCode(() -> inputStringValidator.validateString(opreand2, operator2))
                .doesNotThrowAnyException();
        assertThatCode(() -> inputStringValidator.validateString(opreand3, operator3))
                .doesNotThrowAnyException();
        assertThatCode(() -> inputStringValidator.validateString(opreand4, operator4))
                .doesNotThrowAnyException();

    }

    @Test
    void 구문_예외_확인_테스트() {
        //given
        String opreand1 = "4:,2:1";
        String operator1 = "+";

        String opreand2 = "4:2,";
        String operator2 = "*";

        String opreand3 = "";
        String operator3 = "+";

        String opreand4 = " ";
        String operator4 = "/";

        String opreand5 = ":23,2";
        String operator5 = "/";

        String opreand6 = "12,3:0";
        String operator6 = "";

        // when & then
        assertSoftly( softly -> {
            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand1, operator1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand2, operator2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand3, operator3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand4, operator4))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand5, operator5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERAND);

            softly.assertThatThrownBy(() -> inputStringValidator.validateString(opreand6, operator6))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BAD_REQUEST_OPERATOR);
                }
        );

    }
}

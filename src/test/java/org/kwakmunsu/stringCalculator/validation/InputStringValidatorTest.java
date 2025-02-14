package org.kwakmunsu.stringCalculator.validation;

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
        assertDoesNotThrow(() -> inputStringValidator.validateString(opreand1, operator1));
        assertDoesNotThrow(() -> inputStringValidator.validateString(opreand2, operator2));
        assertDoesNotThrow(() -> inputStringValidator.validateString(opreand3, operator3));
        assertDoesNotThrow(() -> inputStringValidator.validateString(opreand4, operator4));

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
        assertAll(
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand1, operator1));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERAND, ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand2, operator2));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERAND, ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand3, operator3));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERAND, ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand4, operator4));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERAND, ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand5, operator5));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERAND, ex.getMessage());
                },
                () -> {
                    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                            () -> inputStringValidator.validateString(opreand6, operator6));
                    assertEquals(ErrorMessage.BAD_REQUEST_OPERATOR, ex.getMessage());
                }
        );
    }

}

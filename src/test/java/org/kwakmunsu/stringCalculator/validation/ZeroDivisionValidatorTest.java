package org.kwakmunsu.stringCalculator.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.stringCalculator.error.ErrorMessage;

class ZeroDivisionValidatorTest {

    private ZeroDivisionValidator zeroDivisionValidator;

    @BeforeEach
    void setUp() {
        zeroDivisionValidator = new ZeroDivisionValidator();
    }
    @Test
    void ZERO_나눗셈_정상작동_테스트() {
        //given
        int num = 2;
        String op = "/";

        //when & then
        assertThatCode(() -> zeroDivisionValidator.checkForZeroDivision(num, op))
                .doesNotThrowAnyException();
    }
    @Test
    void ZERO_나눗셈_예외_테스트() {
        //given
        int num = 0;
        String op = "/";

        //when & then
        assertThatThrownBy(() -> zeroDivisionValidator.checkForZeroDivision(num, op))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(ErrorMessage.ZERO_DIVISION);

    }
}
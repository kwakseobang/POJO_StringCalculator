package org.kwakmunsu.stringCalculator.validation;

import org.kwakmunsu.stringCalculator.error.response.ErrorMessage;

public class ZeroDivisionValidator {
    public void checkForZeroDivision(int num, String op) throws ArithmeticException {
        if (num == 0 && op.equals("/")) {
            throw new ArithmeticException(ErrorMessage.ZERO_DIVISION);
        }
    }
}

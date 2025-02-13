package org.kwakmunsu.stringCalculator.validation;

import org.kwakmunsu.stringCalculator.error.ErrorMessage;

public class InputStringValidator {

    private final String numSeparator = "^[0-9]+([,:][0-9]+)*$";

    private final String OpSymbolSeparator = "[+\\-*/]";

    public void validateString(String expression,String op) throws IllegalArgumentException {

        if (!expression.matches(numSeparator)) {
          throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERAND);
        }
        if (!op.matches(OpSymbolSeparator)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERATOR);
        }

    }
}

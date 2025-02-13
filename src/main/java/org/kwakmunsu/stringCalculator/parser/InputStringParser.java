package org.kwakmunsu.stringCalculator.parser;

public class InputStringParser {
    private String seperator = ",|:";
    public String[] operandParser(String operand) {
        return operand.split(seperator);
    }
}

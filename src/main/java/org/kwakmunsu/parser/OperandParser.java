package org.kwakmunsu.parser;

public class OperandParser {

    private OperandParser() {
    }

    public static String[] splitOperand(String operand) {
        String separator = ",|:";
        return operand.split(separator);
    }

}
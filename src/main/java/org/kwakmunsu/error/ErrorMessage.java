package org.kwakmunsu.error;

public enum ErrorMessage {

    BAD_REQUEST_OPERAND("ERROR - 피연산자를 잘못 입력하셨습니다."),
    BAD_REQUEST_OPERATOR("ERROR - 연산자를 잘못 입력하셨습니다."),
    ZERO_DIVISION("ERROR - 0으로 나눌 수 없습니다."),
    NOT_MIN_INPUT_EXPRESSION("ERROR - 연산자와 피연산자 모두 입력하셔야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
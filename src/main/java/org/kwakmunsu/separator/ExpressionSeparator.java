package org.kwakmunsu.separator;

import org.kwakmunsu.input.Expression;
import org.kwakmunsu.error.ErrorMessage;

public class ExpressionSeparator {

    private static final String SEPARATOR = ",|:";
    private static final String OPERAND_SEPARATOR = "^[0-9]+([,:][0-9]+)*$";
    private static final String OPERATOR_SEPARATOR = "[+\\-*/]";

    private String operands;
    private String operator;

    public Expression separateExpression(String operands, String operator) {
        setOperands(operands);
        setOperator(operator);
        // 연산자, 피연산자 유효성 검증은 expression 를 만들어낸 이 클래스에서 책임져줘야 생각했음.
        validateExpression();
        String[] seperatedOperands = separateOperands();
        return new Expression(seperatedOperands, operator);
    }

    private void setOperands(String operands) {
        this.operands = operands;
    }

    private void setOperator(String operator) {
        this.operator = operator;
    }

    private String[] separateOperands() {
        return operands.split(SEPARATOR);
    }

    private void validateExpression() {
        validateOperands();
        validateOperator();
    }

    private void validateOperands() {
        if (!operands.matches(OPERAND_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
        }
    }

    private void validateOperator() {
        if (!operator.matches(OPERATOR_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
        }
    }

}
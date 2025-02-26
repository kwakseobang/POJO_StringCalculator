package org.kwakmunsu.parser;

import org.kwakmunsu.Input.Expression;
import org.kwakmunsu.operation.OperationSelector;
import org.kwakmunsu.error.ErrorMessage;

public class ExpressionSeparator {

    private static final String SEPARATOR = ",|:";
    private static final String OPERAND_SEPARATOR = "^[0-9]+([,:][0-9]+)*$";
    private static final String OPERATOR_SEPARATOR = "[+\\-*/]";

    private OperationSelector operationSelector;
    private String operand;
    private String operator;

    public ExpressionSeparator() {
        this.operationSelector = new OperationSelector();
    }

    public Expression separateExpression(String operand, String operator) {
        setOperand(operand);
        setOperator(operator);
        validateExpression();
        String[] seperatedOperand = separateOperand();
        return new Expression(seperatedOperand, operationSelector.selecteOperation(operator));
    }

    private void setOperand(String operand) {
        this.operand = operand;
    }

    private void setOperator(String operator) {
        this.operator = operator;
    }

    private String[] separateOperand() {
        return operand.split(SEPARATOR);
    }

    private void validateExpression() {
        validateOperand();
        validateOperator();
    }

    private void validateOperand() {
        if (!operand.matches(OPERAND_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERAND.getMessage());
        }
    }

    private void validateOperator() {
        if (!operator.matches(OPERATOR_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.BAD_REQUEST_OPERATOR.getMessage());
        }
    }

}
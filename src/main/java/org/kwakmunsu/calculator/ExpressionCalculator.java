package org.kwakmunsu.calculator;

import static org.kwakmunsu.operation.Operation.getOperation;

import org.kwakmunsu.input.Expression;
import org.kwakmunsu.operation.Operation;

public class ExpressionCalculator {

    private Operation operation;

    public double calculateExpression(Expression expression) {
        this.operation = getOperation(expression.operator());
        return operation.calculate(expression.operands());
    }

}
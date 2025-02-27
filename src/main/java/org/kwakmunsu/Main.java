package org.kwakmunsu;

import org.kwakmunsu.calculator.ExpressionCalculator;
import org.kwakmunsu.input.Expression;
import org.kwakmunsu.input.InputExpression;
import org.kwakmunsu.output.ExpressionResultDisplay;

public class Main {

    public static void main(String[] args) {
        InputExpression inputExpression = new InputExpression();
        ExpressionResultDisplay expressionResultDisplay = new ExpressionResultDisplay();
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();

        Expression expression = inputExpression.createExpression();

        double result = expressionCalculator.calculateExpression(expression);

        expressionResultDisplay.resultPrinter(expression, result);
    }

}
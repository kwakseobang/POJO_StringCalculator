package org.kwakmunsu.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.kwakmunsu.error.ErrorMessage;
import org.kwakmunsu.error.ExitException;

public class InputExpression {

    public ExpressionData input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String operand = stringTokenizer.nextToken();
            if (operand.equals("q")) {
                throw new ExitException();
            }
            String operator = stringTokenizer.nextToken();
            return new ExpressionData(operand, operator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(ErrorMessage.NO_SUCH_ELEMENT.getMessage());
        }
    }

}
package org.kwakmunsu.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.error.ErrorMessage;

class InputExpressionTest {


    private InputExpression inputExpression;

    @BeforeEach
    void setUp() {
        inputExpression = new InputExpression();
    }

    @Test
    void 정상_입력_테스트() throws IOException {
        // given
        String input = "10,20:30 +";
        String[] operands = {"10", "20", "30"};
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        Expression result = inputExpression.createExpression();
        // then
        assertThat(result).isNotNull();
        assertThat(result.operands()).isEqualTo(operands);
        assertThat(result.operator()).isEqualTo("+");
    }

    @Test
    void 연산자_공백_입력_예외_테스트() {
        // given
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(() -> inputExpression.createExpression())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_MIN_INPUT_EXPRESSION.getMessage());
    }

    @Test
    void 빈_입력_예외_테스트() {
        // given
        String input = "";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(() -> inputExpression.createExpression())
            .isInstanceOf(NoSuchElementException.class)
            .hasMessage(ErrorMessage.NO_SUCH_ELEMENT.getMessage());
    }
}
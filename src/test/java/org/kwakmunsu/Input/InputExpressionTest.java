package org.kwakmunsu.Input;

import static org.junit.jupiter.api.Assertions.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.error.ExitException;

class InputExpressionTest {

    private InputExpression inputExpression;

    @BeforeEach
    void setUp() {
        inputExpression = new InputExpression();
    }

    @Test
    void 정상_입력_테스트() throws IOException {
        // given
        String input = "10 +";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        ExpressionData result = inputExpression.input();
        // then
        assertThat(result).isNotNull();
        assertThat(result.operand()).isEqualTo("10");
        assertThat(result.operator()).isEqualTo("+");
    }

    @Test
    void 종료_예외_테스트() {
        // given
        String input = "q";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(() -> inputExpression.input())
            .isInstanceOf(ExitException.class);
    }

    @Test
    void 잘못된_입력_예외_테스트() {
        // given
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when & then
        assertThatThrownBy(() -> inputExpression.input())
            .isInstanceOf(NoSuchElementException.class);
    }

}
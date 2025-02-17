package org.kwakmunsu.parser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.kwakmunsu.parser.OperandParser;

class OperandParserTest {

    // 로직이 유효성 검증을 먼저 하기에 여기엔 정상적인 operand 만 들어옴.
    @Test
    void 피연산자_정상작동_테스트() {
        // given
        String operand1 = "3:2,4";
        String[] result = {"3", "2", "4"};
        // when & then
        assertThat(OperandParser.splitOperand(operand1)).isEqualTo(result);
    }

}
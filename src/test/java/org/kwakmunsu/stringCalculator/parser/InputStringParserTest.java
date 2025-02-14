package org.kwakmunsu.stringCalculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kwakmunsu.stringCalculator.PrintResult;

class InputStringParserTest {
    private InputStringParser inputStringParser;

    @BeforeEach
    void setUp() {
        inputStringParser = new InputStringParser();
    }

    // 로직이 유효성 검증을 먼저 하기에 여기엔 정상적인 operand만 들어옴.
    @Test
    void operand_정상작동_테스트() {
        // given
         String operand1 ="3:2,4";
         String[] result = {"3","2","4"};
         assertThat(inputStringParser.operandParser(operand1)).isEqualTo(result);

    }
}
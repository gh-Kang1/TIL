package com.nextstep.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Autowired
    StringCalculator calculator;

    @Test
    public void add() {
        assertThat(StringCalculator.add("1,2,6,2")).isEqualTo(11);
        assertThat(StringCalculator.add("")).isEqualTo(0);
        assertThat(StringCalculator.add("3")).isEqualTo(3);
        assertThat(StringCalculator.add("//!\n1!2!5!7!")).isEqualTo(15);
        assertThrows(RuntimeException.class,() -> {
            StringCalculator.add("1,2,3,-1");
        });
    }
}
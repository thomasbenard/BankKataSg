package com.kata.sg;

import org.junit.jupiter.api.Test;

import static com.kata.sg.Currency.DOLLARS;
import static com.kata.sg.Currency.EUROS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void can_sum_two_money_with_same_currency() {
        assertThat(new Money(10.0, EUROS).plus(new Money(20.0, EUROS))).isEqualTo(new Money(30.0, EUROS));
    }

    @Test
    void summing_two_money_with_deffirent_currencies_is_not_yet_implemented() {
        assertThatThrownBy(() -> new Money(10.0, EUROS).plus(new Money(20.0, DOLLARS))).isInstanceOf(RuntimeException.class);
    }
}
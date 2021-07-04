package com.kata.sg;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.emptyList;

class AccountStatementFormatterTest {

    private final AccountStatementFormatter accountStatementFormatter = new AccountStatementFormatter();

    @Test
    void prints_an_empty_header_given_no_transaction() {
        List<Transaction> transactions = emptyList();
        assertThat(accountStatementFormatter.format(transactions))
                .isEqualToIgnoringWhitespace("DATE | AMOUNT | BALANCE");
    }

    @Test
    void prints_a_single_transaction_given_one_transaction() {
        List<Transaction> transactions = List.of(new Transaction(new Date(1, 12, 2020), new Money(50.0, Currency.EUROS)));
        assertThat(accountStatementFormatter.format(transactions))
                .isEqualToIgnoringWhitespace("""
                            DATE | AMOUNT | BALANCE
                            1/12/2020 | 50.0€ | 50.0€
                            """);
    }

    @Test
    void printing_multiple_transactions_computes_balance() {
        List<Transaction> transactions = List.of(
                new Transaction(new Date(1, 12, 2020), new Money(50.0, Currency.EUROS)),
                new Transaction(new Date(2, 12, 2020), new Money(-20.0, Currency.EUROS)));
        assertThat(accountStatementFormatter.format(transactions))
                .isEqualToIgnoringWhitespace("""
                            DATE | AMOUNT | BALANCE
                            1/12/2020 | 50.0€ | 50.0€
                            2/12/2020 | -20.0€ | 30.0€
                            """);
    }
}
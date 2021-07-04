package com.kata.sg;

import org.junit.jupiter.api.Test;

import static com.kata.sg.Currency.EUROS;
import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    private final FakeClock clock = new FakeClock(new Date(4, 7, 2021));
    private final FakeTransactionRepository transactionRepository = new FakeTransactionRepository();

    @Test
    void making_a_deposit_adds_a_transaction_to_statements() {
        new Account(clock, transactionRepository)
                .deposit(100.0, EUROS);
        assertThat(transactionRepository.allTransactions()).contains(
                new Transaction(new Date(4, 7, 2021), new Money(100.0, EUROS)));
    }

    @Test
    void can_make_multiple_deposits() {
        Account account = new Account(clock, transactionRepository)
                .deposit(100.0, EUROS);
        clock.set(new Date(5, 7, 2021));
        account.deposit(50.0, EUROS);
        assertThat(transactionRepository.allTransactions()).contains(
                new Transaction(new Date(4, 7, 2021), new Money(100.0, EUROS)),
                new Transaction(new Date(5, 7, 2021), new Money(50.0, EUROS)));
    }

    @Test
    void can_make_withdrawals() {
        new Account(clock, transactionRepository)
                .deposit(100.0, EUROS)
                .withdraw(20.0, EUROS);
        assertThat(transactionRepository.allTransactions()).contains(
                new Transaction(new Date(4, 7, 2021), new Money(100.0, EUROS)),
                new Transaction(new Date(4, 7, 2021), new Money(-20.0, EUROS)));
    }
}
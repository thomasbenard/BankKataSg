package com.kata.sg;

import org.junit.jupiter.api.Test;

import static com.kata.sg.Currency.EUROS;
import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {
    private final FakeClock clock = new FakeClock(new Date(4, 7, 2021));
    private final FakeTransactionRepository transactionRepository = new FakeTransactionRepository();
    private final AccountStatementFormatter accountStatementFormatter = new AccountStatementFormatter();

    @Test
    void name() {
        Account account = new Account(clock, transactionRepository)
                .deposit(100.0, EUROS);
        clock.set(new Date(5, 7, 2021));
        account.withdraw(30.0, EUROS);
        clock.set(new Date(7, 7, 2021));
        account.deposit(50.0, EUROS);

        assertThat(account.format(accountStatementFormatter))
                .isEqualToIgnoringWhitespace("""
                            DATE | AMOUNT | BALANCE
                            4/7/2021 | 100.0€ | 100.0€
                            5/7/2021 | -30.0€ | 70.0€
                            7/7/2021 | 50.0€ | 120.0€
                            """);
    }
}

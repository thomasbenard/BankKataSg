package com.kata.sg;

public class Account {
    private final Clock clock;
    private final TransactionRepository transactionRepository;

    public Account(final Clock clock, final TransactionRepository transactionRepository) {
        this.clock = clock;
        this.transactionRepository = transactionRepository;
    }

    public Account deposit(final double amount, final Currency currency) {
        transactionRepository.add(new Transaction(clock.now(), new Money(amount, currency)));
        return this;
    }

    public Account withdraw(final double amount, final Currency currency) {
        transactionRepository.add(new Transaction(clock.now(), new Money(-amount, currency)));
        return this;
    }

    public String format(final AccountStatementFormatter accountStatementFormatter) {
        return accountStatementFormatter.format(transactionRepository.allTransactions());
    }
}

package com.kata.sg;

import java.util.Objects;

public class Transaction {
    private final Date date;
    private final Money amount;

    public Transaction(final Date date, final Money amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    public String format(final AccountStatementFormatter accountStatementFormatter, Money balance) {
        return accountStatementFormatter.formatTransaction(date, amount, balance);
    }

    public Money computeNewBalance(final Money balance) {
        return balance.plus(amount);
    }
}

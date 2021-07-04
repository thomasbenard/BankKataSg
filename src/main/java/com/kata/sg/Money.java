package com.kata.sg;

import java.util.Objects;

public class Money {
    private final double amount;
    private final Currency currency;

    public Money(final double amount, final Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 &&
                currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public String format(final AccountStatementFormatter accountStatementFormatter) {
        return accountStatementFormatter.formatMoney(amount, currency);
    }

    public Money plus(final Money money) {
        if (!currency.equals(money.currency)) {
            throw new RuntimeException("Not yet implemented");
        }
        return new Money(amount + money.amount, currency);
    }
}

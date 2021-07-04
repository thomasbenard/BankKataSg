package com.kata.sg;

import java.util.List;

import static com.kata.sg.Currency.EUROS;

public class AccountStatementFormatter {

    private static final String HEADER = "DATE | AMOUNT | BALANCE";
    private static final String SEPARATOR = " | ";
    private static final String NEW_LINE = "\n";

    public String format(final List<Transaction> transactions) {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append(NEW_LINE);
        Money balance = new Money(0, EUROS);
        for(Transaction transaction : transactions){
            balance = transaction.computeNewBalance(balance);
            sb.append(transaction.format(this, balance)).append(NEW_LINE);
        }
        return sb.toString();
    }

    public String formatTransaction(final Date date, final Money amount, final Money balance) {
        return date.format(this) + SEPARATOR + amount.format(this) + SEPARATOR + balance.format(this);
    }

    public String formatDate(final int day, final int month, final int year) {
        return day + "/" + month + "/" + year;
    }

    public String formatMoney(final double amount, final Currency currency) {
        return amount + currency.symbol;
    }
}

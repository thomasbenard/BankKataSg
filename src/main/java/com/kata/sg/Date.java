package com.kata.sg;

import java.util.Objects;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(final int day, final int month, final int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public String format(final AccountStatementFormatter accountStatementFormatter) {
        return accountStatementFormatter.formatDate(day, month, year);
    }
}

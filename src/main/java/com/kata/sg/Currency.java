package com.kata.sg;

public enum Currency {
    EUROS("€"),
    DOLLARS("$");

    public final String symbol;

    Currency(final String symbol) {
        this.symbol = symbol;
    }
}

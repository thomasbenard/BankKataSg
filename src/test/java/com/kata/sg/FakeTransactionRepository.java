package com.kata.sg;

import java.util.LinkedList;
import java.util.List;

public class FakeTransactionRepository implements TransactionRepository {

    private final List<Transaction> transactions = new LinkedList<>();

    @Override
    public List<Transaction> allTransactions() {
        return transactions;
    }

    @Override
    public void add(final Transaction transaction) {
        transactions.add(transaction);
    }
}

package com.kata.sg;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> allTransactions();

    void add(Transaction transaction);
}

package com.n26.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transactions {

    public static List<Transaction> transactions = new ArrayList<>();
    private Object lock = new Object();

    public void addTransactions(Transaction transaction){
        ZonedDateTime now60 = ZonedDateTime.now().minusSeconds(60);
        synchronized (lock){
            if(transaction.getTimestamp().isAfter(now60) && transaction.getTimestamp().isBefore(ZonedDateTime.now()))
                this.transactions.add(transaction);
        }
    }

}

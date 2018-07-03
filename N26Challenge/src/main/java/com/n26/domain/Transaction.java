package com.n26.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Transaction {

    double amount;
    ZonedDateTime timestamp;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

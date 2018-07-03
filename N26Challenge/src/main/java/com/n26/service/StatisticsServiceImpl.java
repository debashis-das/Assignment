package com.n26.service;

import com.n26.domain.Transactions;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    Object lock = new Object();

    @Override
    public DoubleSummaryStatistics calculateStatics() {
        ZonedDateTime now60 = ZonedDateTime.now().minusSeconds(60);
        synchronized (lock) {
            Transactions.transactions = Transactions.transactions.stream().filter(transaction -> transaction.getTimestamp().isAfter(now60) && transaction.getTimestamp().isBefore(ZonedDateTime.now()))
                    .collect(Collectors.toList());
            return Transactions.transactions.stream().mapToDouble((x) -> x.getAmount()).summaryStatistics();
        }
    }


}

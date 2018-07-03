package com.n26.controller;

import com.n26.domain.Transaction;
import com.n26.domain.Transactions;
import com.n26.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
public class TransactionController {

    Transactions transactions = new Transactions();

    @Autowired
    StatisticsService statisticsService;

    @RequestMapping("/transactions")
    @PostMapping
    public void createTransaction(@RequestBody Transaction currentTransaction)
    {
        transactions.addTransactions(currentTransaction);
    }

    @RequestMapping("/statistics")
    @GetMapping
    public DoubleSummaryStatistics getStatistics(){
        return statisticsService.calculateStatics();
    }

}

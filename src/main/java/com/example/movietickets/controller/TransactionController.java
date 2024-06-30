package com.example.movietickets.controller;

import com.example.movietickets.model.TransactionRequest;
import com.example.movietickets.model.TransactionResponse;
import com.example.movietickets.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(@Autowired TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/project-cost")
    public TransactionResponse projectCost(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.calculateTotalCost(
                transactionRequest.getTransactionId(),
                transactionRequest.getCustomers()
        );
    }
}

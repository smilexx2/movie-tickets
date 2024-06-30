package com.example.movietickets;

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

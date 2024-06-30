package com.example.movietickets;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @PostMapping("/project-cost")
    public TransactionResponse projectCost(@RequestBody TransactionRequest transactionRequest) {

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(transactionRequest.getTransactionId());
        return transactionResponse;
    }
}

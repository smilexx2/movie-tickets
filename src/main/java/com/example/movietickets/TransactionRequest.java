package com.example.movietickets;

import com.example.movietickets.domain.Customer;

import java.util.List;

public class TransactionRequest {
    private int transactionId;
    private List<Customer> customers;

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customers=" + customers +
                '}';
    }
}


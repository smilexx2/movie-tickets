package com.example.movietickets;

import com.example.movietickets.domain.Ticket;

import java.util.List;
import java.util.Objects;

public class TransactionResponse {
    private int transactionId;
    private List<Ticket> tickets;
    private double totalCost;

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "transactionId=" + transactionId +
                ", tickets=" + tickets +
                ", totalCost=" + totalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponse that = (TransactionResponse) o;
        return transactionId == that.transactionId &&
                Double.compare(that.totalCost, totalCost) == 0 &&
                Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, tickets, totalCost);
    }
}


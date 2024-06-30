package com.example.movietickets;

import java.util.List;

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

    // Ticket inner class
    public static class Ticket {
        private String ticketType;
        private int quantity;
        private double totalCost;

        // Getters and Setters
        public String getTicketType() {
            return ticketType;
        }

        public void setTicketType(String ticketType) {
            this.ticketType = ticketType;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "ticketType='" + ticketType + '\'' +
                    ", quantity=" + quantity +
                    ", totalCost=" + totalCost +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "transactionId=" + transactionId +
                ", tickets=" + tickets +
                ", totalCost=" + totalCost +
                '}';
    }
}


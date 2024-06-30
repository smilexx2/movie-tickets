package com.example.movietickets.domain;

import java.util.Objects;

public class Ticket {
    private String ticketType;
    private long quantity;
    private double totalCost;

    public Ticket(String ticketType, long quantity, double totalCost) {
        this.ticketType = ticketType;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    // Getters and Setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public long getQuantity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return quantity == ticket.quantity &&
                Double.compare(ticket.totalCost, totalCost) == 0 &&
                Objects.equals(ticketType, ticket.ticketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketType, quantity, totalCost);
    }
}

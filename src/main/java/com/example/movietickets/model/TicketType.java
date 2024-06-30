package com.example.movietickets.model;

public enum TicketType {
    ADULT(25, "Adult"),
    SENIOR("Senior"),
    TEEN(12, "Teen"),
    CHILDREN(5, "Children");

    private final Double basePrice;
    private final String ticketType;

    TicketType(double basePrice, String ticketType) {
        this.basePrice = basePrice;
        this.ticketType = ticketType;
    }

    TicketType(String ticketType) { // Constructor for SENIOR without base price
        this.basePrice = null;
        this.ticketType = ticketType;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public String getTicketType() {
        return ticketType;
    }
}

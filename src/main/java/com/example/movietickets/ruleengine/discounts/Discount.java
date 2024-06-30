package com.example.movietickets.ruleengine.discounts;

public interface Discount {
    double apply(double basePrice, long ticketCount);
}

package com.example.movietickets.ruleengine.discounts;

public class SeniorDiscount implements Discount {
    @Override
    public double apply(double basePrice, long ticketCount) {
        return basePrice * 0.7; // 30% discount for seniors
    }
}

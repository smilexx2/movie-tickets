package com.example.movietickets.ruleengine.discounts;

public class NoDiscount implements Discount{
    @Override
    public double apply(double basePrice, long ticketCount) {
        return basePrice;
    }
}

package com.example.movietickets.ruleengine.discounts;

public class BulkDiscount implements Discount{
    private final long threshold;
    private final double discountRate;

    public BulkDiscount(long threshold, double discountRate) {
        this.threshold = threshold;
        this.discountRate = discountRate;
    }

    @Override
    public double apply(double basePrice, long ticketCount) {
        if (ticketCount >= threshold) {
            return basePrice * discountRate;
        }
        return basePrice;
    }
}

package com.example.movietickets.ruleengine.rules;

import com.example.movietickets.domain.TicketType;
import com.example.movietickets.domain.Customer;
import com.example.movietickets.ruleengine.conditions.Condition;
import com.example.movietickets.ruleengine.discounts.Discount;

import java.util.List;

public class SimpleRule implements Rule {
    private final List<Condition> conditions;
    private final TicketType ticketType;
    private final Discount discount;

    public SimpleRule(List<Condition> conditions, TicketType ticketType, Discount discount) {
        this.conditions = conditions;
        this.ticketType = ticketType;
        this.discount = discount;
    }

    @Override
    public boolean matches(Customer customer) {
        return conditions.stream().allMatch(condition -> condition.matches(customer));
    }

    @Override
    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public double calculatePrice(long ticketCount) {
        return discount.apply(ticketType.getBasePrice(), ticketCount);
    }
}

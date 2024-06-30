package com.example.movietickets.ruleengine.rules;

import com.example.movietickets.domain.TicketType;
import com.example.movietickets.domain.Customer;
import com.example.movietickets.ruleengine.conditions.Condition;
import com.example.movietickets.ruleengine.discounts.Discount;

import java.util.List;

public class SeniorRule implements Rule {
    private final List<Condition> conditions;
    private final Discount discount;

    public SeniorRule(List<Condition> conditions, Discount discount) {
        this.conditions = conditions;
        this.discount = discount;
    }

    @Override
    public boolean matches(Customer customer) {
        return conditions.stream().allMatch(condition -> condition.matches(customer));
    }

    @Override
    public TicketType getTicketType() {
        return TicketType.SENIOR;
    }

    @Override
    public double calculatePrice(long ticketCount) {
        return discount.apply(TicketType.ADULT.getBasePrice(), ticketCount);
    }
}

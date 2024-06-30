package com.example.movietickets.ruleengine.rules;

import com.example.movietickets.domain.TicketType;
import com.example.movietickets.domain.Customer;

public interface Rule {
    boolean matches(Customer customer);
    TicketType getTicketType();
    double calculatePrice(long childrenTicketCount);
}


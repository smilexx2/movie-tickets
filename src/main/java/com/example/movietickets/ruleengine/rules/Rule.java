package com.example.movietickets.ruleengine.rules;

import com.example.movietickets.model.TicketType;
import com.example.movietickets.model.Customer;

public interface Rule {
    boolean matches(Customer customer);
    TicketType getTicketType();
    double calculatePrice(long childrenTicketCount);
}


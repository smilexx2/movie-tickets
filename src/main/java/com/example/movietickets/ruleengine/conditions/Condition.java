package com.example.movietickets.ruleengine.conditions;

import com.example.movietickets.domain.Customer;

public interface Condition {
    boolean matches(Customer customer);
}

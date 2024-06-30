package com.example.movietickets.ruleengine.conditions;

import com.example.movietickets.model.Customer;

public interface Condition {
    boolean matches(Customer customer);
}

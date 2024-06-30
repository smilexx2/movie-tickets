package com.example.movietickets.ruleengine.conditions;

import com.example.movietickets.model.Customer;

public class AgeCondition implements Condition{
    private final int minAge;
    private final int maxAge;

    public AgeCondition(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean matches(Customer customer) {
        int age = customer.getAge();
        return age >= minAge && age <= maxAge;
    }
}

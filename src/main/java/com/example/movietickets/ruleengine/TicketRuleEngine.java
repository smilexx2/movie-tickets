package com.example.movietickets.ruleengine;

import com.example.movietickets.model.TicketCost;
import com.example.movietickets.model.TicketType;
import com.example.movietickets.model.Customer;
import com.example.movietickets.ruleengine.conditions.AgeCondition;
import com.example.movietickets.ruleengine.discounts.BulkDiscount;
import com.example.movietickets.ruleengine.discounts.NoDiscount;
import com.example.movietickets.ruleengine.discounts.SeniorDiscount;
import com.example.movietickets.ruleengine.rules.Rule;
import com.example.movietickets.ruleengine.rules.SeniorRule;
import com.example.movietickets.ruleengine.rules.SimpleRule;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketRuleEngine {
    private final List<Rule> rules;

    public TicketRuleEngine() {
        rules = Arrays.asList(
                new SimpleRule(List.of(new AgeCondition(0, 10)), TicketType.CHILDREN, new BulkDiscount(3, 0.75)),
                new SimpleRule(List.of(new AgeCondition(11, 17)), TicketType.TEEN, new NoDiscount()),
                new SimpleRule(List.of(new AgeCondition(18, 64)), TicketType.ADULT, new NoDiscount()),
                new SeniorRule(List.of(new AgeCondition(65, Integer.MAX_VALUE)), new SeniorDiscount())
        );
    }

    public TicketType determineTicketType(Customer customer) {
        return rules.stream()
                .filter(rule -> rule.matches(customer))
                .map(Rule::getTicketType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching rule for customer"));
    }

    public Map<TicketType, TicketCost> calculateTotalCost(List<TicketType> ticketTypes) {
        // Group each ticket types with counts
        Map<TicketType, Long> ticketTypeCounts = ticketTypes.stream()
                .collect(Collectors.groupingBy(ticket -> ticket, Collectors.counting()));

        return ticketTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            TicketType ticketType = entry.getKey();
                            long count = entry.getValue();
                            // Find rule for ticket type
                            Rule rule = rules.stream()
                                    .filter(r -> r.getTicketType() == ticketType)
                                    .findFirst()
                                    .orElseThrow(() -> new IllegalArgumentException("No matching rule for ticket type"));
                            // Calculate total cost for ticket type
                            double totalCost = rule.calculatePrice(count) * count;
                            return new TicketCost(count, totalCost);
                        }
                ));
    }
}

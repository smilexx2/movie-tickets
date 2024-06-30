package com.example.movietickets.ruleengine;

import com.example.movietickets.model.Customer;
import com.example.movietickets.model.TicketCost;
import com.example.movietickets.model.TicketType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketRuleEngineTest {
    @Test
    void testChildRule() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();
        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 5),
                new Customer("Jane Doe", 5)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCost = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.CHILDREN);
        assertEquals(2, ticketCost.quantity());
        assertEquals(5 * 2, ticketCost.totalCost());
    }

    @Test
    void testChildRuleWithDiscount() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();
        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 5),
                new Customer("Jane Doe", 5),
                new Customer("Bob Doe", 5)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCost = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.CHILDREN);
        assertEquals(3, ticketCost.quantity());
        assertEquals(5 * 0.75 * 3, ticketCost.totalCost());
    }

    @Test
    void testTeenRule() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();

        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 11),
                new Customer("Jane Doe", 15),
                new Customer("Bob Doe", 17)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCost = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.TEEN);
        assertEquals(3, ticketCost.quantity());
        assertEquals(12 * 3, ticketCost.totalCost());
    }

    @Test
    void testAdultRule() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();

        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 18),
                new Customer("Jane Doe", 30),
                new Customer("Bob Doe", 64)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCost = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.ADULT);
        assertEquals(3, ticketCost.quantity());
        assertEquals(25 * 3, ticketCost.totalCost());
    }

    @Test
    void testSeniorRule() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();

        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 65),
                new Customer("Jane Doe", 70),
                new Customer("Bob Doe", 80)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCost = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.SENIOR);
        assertEquals(3, ticketCost.quantity());
        assertEquals(25 * 0.7 * 3, ticketCost.totalCost());
    }

    @Test
    void testAllTicketTypes() {
        TicketRuleEngine ruleEngine = new TicketRuleEngine();

        List<Customer> customers = Arrays.asList(
                new Customer("John Smith", 70),
                new Customer("Jane Doe", 5),
                new Customer("Bob Doe", 6),
                new Customer("Billy Kidd", 36),
                new Customer("Zoe Daniels", 3),
                new Customer("George White", 8),
                new Customer("Tommy Anderson", 9),
                new Customer("Joe Smith", 17),
                new Customer("Jesse James", 36),
                new Customer("Daniel Anderson", 95),
                new Customer("Mary Jones", 15),
                new Customer("Michelle Parker", 10)
        );

        List<TicketType> ticketTypes = customers.stream()
                .map(ruleEngine::determineTicketType)
                .toList();

        TicketCost ticketCostChildren = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.CHILDREN);
        TicketCost ticketCostTeen = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.TEEN);
        TicketCost ticketCostAdult = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.ADULT);
        TicketCost ticketCostSenior = ruleEngine.calculateTotalCost(ticketTypes).get(TicketType.SENIOR);
        assertEquals(6, ticketCostChildren.quantity());
        assertEquals(5 * 0.75 * 6, ticketCostChildren.totalCost());
        assertEquals(2, ticketCostTeen.quantity());
        assertEquals(12 * 2, ticketCostTeen.totalCost());
        assertEquals(2, ticketCostAdult.quantity());
        assertEquals(25 * 2, ticketCostAdult.totalCost());
        assertEquals(2, ticketCostSenior.quantity());
        assertEquals(25 * 0.7 * 2, ticketCostSenior.totalCost());
    }
}

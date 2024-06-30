package com.example.movietickets.service;

import com.example.movietickets.model.*;
import com.example.movietickets.ruleengine.TicketRuleEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {
    private final TicketRuleEngine ticketRuleEngine;

    public TransactionService(@Autowired TicketRuleEngine ticketRuleEngine) {
        this.ticketRuleEngine = ticketRuleEngine;
    }

    public TransactionResponse calculateTotalCost(int transactionId, List<Customer> customers) {
        List<TicketType> ticketTypes = customers.stream()
                .map(ticketRuleEngine::determineTicketType)
                .toList();

        List<Ticket> tickets = ticketRuleEngine.calculateTotalCost(ticketTypes).entrySet().stream()
                .map(this::createTicket)
                .sorted(Comparator.comparing(Ticket::getTicketType)) // ordered by ticket type alphabetically
                .toList();

        double totalCost = tickets.stream().mapToDouble(Ticket::getTotalCost).sum();

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(transactionId);
        transactionResponse.setTickets(tickets);
        transactionResponse.setTotalCost(totalCost);

        return transactionResponse;
    }

    private Ticket createTicket(Map.Entry<TicketType, TicketCost> entry) {
        String ticketType = entry.getKey().getTicketType();
        TicketCost ticketCost = entry.getValue();

        return new Ticket(ticketType, ticketCost.quantity(), ticketCost.totalCost());

    }

}

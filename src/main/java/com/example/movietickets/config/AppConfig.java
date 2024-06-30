package com.example.movietickets.config;

import com.example.movietickets.ruleengine.TicketRuleEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TicketRuleEngine ticketRuleEngine() {
        return new TicketRuleEngine();
    }

}

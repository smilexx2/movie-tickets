package com.example.movietickets;

import com.example.movietickets.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieTicketsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void projectCostShouldReturnTheTransactionResponse1() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = """
                {
                    "transactionId": 1,
                    "customers": [
                        {
                            "name": "John Smith",
                            "age": 70
                        },
                        {
                            "name": "Jane Doe",
                            "age": 5
                        },
                        {
                            "name": "Bob Doe",
                            "age": 6
                        }
                    ]
                }
                """;
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(
                "/api/transactions/project-cost",
                new HttpEntity<>(body, headers),
                TransactionResponse.class
        );
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(1);
        transactionResponse.setTickets(
                Arrays.asList(
                        new Ticket("Children", 2, 10.00),
                        new Ticket("Senior", 1, 17.50)
                )
        );
        transactionResponse.setTotalCost(27.50);
        assertEquals(transactionResponse, Objects.requireNonNull(response.getBody()));
    }

    @Test
    public void projectCostShouldReturnTheTransactionResponse2() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = """
                {
                    "transactionId": 2,
                    "customers": [
                        {
                            "name": "Billy Kidd",
                            "age": 36
                        },
                        {
                            "name": "Zoe Daniels",
                            "age": 3
                        },
                        {
                            "name": "George White",
                            "age": 8
                        },
                        {
                            "name": "Tommy Anderson",
                            "age": 9
                        },
                        {
                            "name": "Joe Smith",
                            "age": 17
                        }
                    ]
                }
                """;
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(
                "/api/transactions/project-cost",
                new HttpEntity<>(body, headers),
                TransactionResponse.class
        );
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(2);
        transactionResponse.setTickets(
                Arrays.asList(
                        new Ticket("Adult", 1, 25.00),
                        new Ticket("Children", 3, 11.25),
                        new Ticket("Teen", 1, 12.00)
                )
        );
        transactionResponse.setTotalCost(48.25);
        assertEquals(transactionResponse, Objects.requireNonNull(response.getBody()));
    }

    @Test
    public void projectCostShouldReturnTheTransactionResponse3() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = """
                {
                    "transactionId": 3,
                    "customers": [
                        {
                            "name": "Jesse James",
                            "age": 36
                        },
                        {
                            "name": "Daniel Anderson",
                            "age": 95
                        },
                        {
                            "name": "Mary Jones",
                            "age": 15
                        },
                        {
                            "name": "Michelle Parker",
                            "age": 10
                        }
                    ]
                }
                """;
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(
                "/api/transactions/project-cost",
                new HttpEntity<>(body, headers),
                TransactionResponse.class
        );
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(3);
        transactionResponse.setTickets(
                Arrays.asList(
                        new Ticket("Adult", 1, 25.00),
                        new Ticket("Children", 1, 5.00),
                        new Ticket("Senior", 1, 17.50),
                        new Ticket("Teen", 1, 12.00)
                )
        );
        transactionResponse.setTotalCost(59.50);
        assertEquals(transactionResponse, Objects.requireNonNull(response.getBody()));
    }

}

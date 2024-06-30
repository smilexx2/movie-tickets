package com.example.movietickets;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieTicketsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void projectCostShouldReturnTheTransactionId() throws JSONException {
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
        ResponseEntity<String> response = restTemplate.postForEntity("/api/transactions/project-cost", new HttpEntity<>(body, headers), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONObject jsonResponse = new JSONObject(response.getBody());
        assertEquals("1", jsonResponse.getString("transactionId"));
    }

}

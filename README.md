# Movie Tickets Processing Application

## Overview
This is a Spring Boot application that processes movie ticket transactions. The application exposes an API that takes a transaction as input and returns detailed information about the tickets and the total cost of the transaction.

## Requirements
- Java 17 or higher

## Features
- Calculate ticket prices based on customer age categories:
    - Adult: $25 (18 years and older but less than 65 years old)
    - Senior: 30% discount on Adult ticket price (65 years and older)
    - Teen: $12 (11 years and older but less than 18 years old)
    - Children: $5 (less than 11 years old)
- Apply a 25% discount to the total cost of Children tickets if 3 or more Children tickets are purchased in a transaction
- Expose an API to process transactions and return ticket details and total cost

## API Endpoints

### Process Transaction
**URL:** `/api/tickets/process`

**Method:** `POST`

**Request Body:**
```json
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
```

**Response**
```json
{
    "transactionId": 1,
    "tickets": [
        {
            "ticketType": "Children",
            "quantity": 2,
            "totalCost": 10.00
        },
        {
            "ticketType": "Senior",
            "quantity": 1,
            "totalCost": 17.50
        }
    ],
    "totalCost": 27.50
}
```

## Running the Application
1. Build the project using Gradle:

```shell
./gradlew clean build
```

2. Run the application:

```shell
./gradlew bootRun
```
3. The application will be available at http://localhost:8080.

## Running Tests
To run the unit tests, use the following command:

```shell
./gradlew test
```
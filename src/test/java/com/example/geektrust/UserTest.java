package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    public void setup(){
        user = new User("Sumit");
    }

    @Test
    void createLoan() {
        user.createLoan(10000, 5, 4);
        // get amount paid after 5th emi is paid
        long amountPaid = user.getAmountPaid(5);
        assertEquals(1000, amountPaid);
    }

    @Test
    void processPayment() {
        user.createLoan(10000, 5, 4);
        user.processPayment(1000, 5);
        long amountPaid = user.getAmountPaid(5);
        assertEquals(2000, amountPaid);
    }

    @Test
    void getAmountPaid() {
        user.createLoan(10000, 5, 4);
        user.processPayment(1000, 5);
        long amountPaid = user.getAmountPaid(5);
        assertEquals(2000, amountPaid);
    }

    @Test
    void getNumberOfRemainingEmi() {
        user.createLoan(10000, 5, 4);
        user.processPayment(1000, 5);
        long numberOfRemainingEmi = user.getNumberOfRemainingEmi(5);
        assertEquals(50, numberOfRemainingEmi);
    }

    @AfterEach
    public void tearDown(){
        user = null;
    }
}
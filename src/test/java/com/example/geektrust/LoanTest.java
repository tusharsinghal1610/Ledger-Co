package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {

    private Loan loan;

    @BeforeEach
    public void setup(){
        loan = new Loan(5000,1,6);
    }

    @Test
    void processPayment() {
        loan.processPayment(1000, 5);
        long amountPaid = loan.getAmountPaid(5);
        assertEquals(3210, amountPaid);
    }

    @Test
    void getAmountPaid() {
        loan.processPayment(1000, 5);
        long amountPaid = loan.getAmountPaid(5);
        assertEquals(3210, amountPaid);
    }

    @Test
    void getNumberOfRemainingEmi() {
        loan.processPayment(1000, 5);
        long numberOfRemainingEmi = loan.getNumberOfRemainingEmi(5);
        assertEquals(5, numberOfRemainingEmi);
    }

    @AfterEach
    public void tearDown(){
        loan = null;
    }
}

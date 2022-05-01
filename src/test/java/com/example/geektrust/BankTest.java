package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    public void setup(){
        bank = new Bank("UNO");
    }

    @Test
    void createLoan() {
        // create multiple loans, they should not interfere
        bank.createLoan("Sumit", 10000, 5, 4);
        bank.createLoan("Sameer", 20000, 3, 3);
        bank.createLoan("Sanjana", 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid("Sumit", 5);
        assertEquals(1000, amountPaidBySumit);
    }

    @Test
    void processPayment() {
        bank.createLoan("Sumit", 10000, 5, 4);
        bank.createLoan("Sameer", 20000, 3, 3);
        bank.processPayment("Sumit", 1000, 5);
        bank.processPayment("Sameer", 1000, 6);
        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid("Sumit", 5);
        assertEquals(2000, amountPaidBySumit);
    }

    @Test
    void getAmountPaid() {
        // create multiple loans, they should not interfere
        bank.createLoan("Sumit", 10000, 5, 4);
        bank.createLoan("Sameer", 20000, 3, 3);
        bank.createLoan("Sanjana", 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid("Sumit", 5);
        assertEquals(1000, amountPaidBySumit);
    }

    @Test
    void getNumberOfRemainingEmi() {
        // create multiple loans, they should not interfere
        bank.createLoan("Sumit", 10000, 5, 4);
        bank.createLoan("Sameer", 20000, 3, 3);
        bank.createLoan("Sanjana", 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        int numberOfRemainingEmi = bank.getNumberOfRemainingEmi("Sumit", 5);
        assertEquals(55, numberOfRemainingEmi);
    }

    @AfterEach
    public void tearDown(){
        bank = null;
    }

}
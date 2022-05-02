package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private User sumit;
    private User sameer;
    private User sanjana;

    @BeforeEach
    public void setup(){
        bank = new Bank("UNO");
        sumit = new User("Sumit");
        sameer = new User("Sameer");
        sanjana = new User("Sanjana");
    }

    @Test
    void createLoan() {
        // create multiple loans, they should not interfere
        bank.createLoan(sumit, 10000, 5, 4);
        bank.createLoan(sameer, 20000, 3, 3);
        bank.createLoan(sanjana, 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid(sumit, 5);
        assertEquals(1000, amountPaidBySumit);
    }

    @Test
    void processPayment() {
        bank.createLoan(sumit, 10000, 5, 4);
        bank.createLoan(sameer, 20000, 3, 3);
        bank.processPayment(sumit, 1000, 5);
        bank.processPayment(sameer, 1000, 6);
        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid(sumit, 5);
        assertEquals(2000, amountPaidBySumit);
    }

    @Test
    void getAmountPaid() {
        // create multiple loans, they should not interfere
        bank.createLoan(sumit, 10000, 5, 4);
        bank.createLoan(sameer, 20000, 3, 3);
        bank.createLoan(sanjana, 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        long amountPaidBySumit = bank.getAmountPaid(sumit, 5);
        assertEquals(1000, amountPaidBySumit);
    }

    @Test
    void getNumberOfRemainingEmi() {
        // create multiple loans, they should not interfere
        bank.createLoan(sumit, 10000, 5, 4);
        bank.createLoan(sameer, 20000, 3, 3);
        bank.createLoan(sanjana, 50000, 10, 5);

        // check for amount paid by sumit after payment of 5th emi
        int numberOfRemainingEmi = bank.getNumberOfRemainingEmi(sumit, 5);
        assertEquals(55, numberOfRemainingEmi);
    }

    @AfterEach
    public void tearDown(){
        bank = null;
    }

}
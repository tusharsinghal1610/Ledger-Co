package com.example.geektrust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LedgerTest {
    private Ledger ledger;

    @BeforeEach
    public void setup(){
        ledger = new Ledger();
    }

    @Test
    void createLoan() {
        // create loans with various banks and users
        ledger.createLoan("UNO", "Sumit", 10000, 5, 4);
        ledger.createLoan("IDIDI", "Sumit", 20000, 4, 5);
        ledger.createLoan("HDFC", "Sanjana", 50000, 3, 6);
        ledger.createLoan("UNO", "Aniket", 60000, 6, 3);

        // check balance statement
        String balanceStatement = ledger.getBalanceStatement("UNO", "Sumit", 5);
        assertEquals(balanceStatement, "UNO Sumit 1000 55");
    }

    @Test
    void processPayment() {
        // create loans with various banks and users
        ledger.createLoan("UNO", "Sumit", 10000, 5, 4);
        ledger.createLoan("IDIDI", "Sumit", 20000, 4, 5);
        ledger.createLoan("HDFC", "Sanjana", 50000, 3, 6);
        ledger.createLoan("UNO", "Aniket", 60000, 6, 3);

        // process payments
        ledger.processPayment("UNO", "Sumit", 1000, 5);
        ledger.processPayment("UNO", "Aniket", 1000, 5);
        ledger.processPayment("IDIDI", "Sumit", 1000, 5);

        // check balance statement
        String balanceStatement = ledger.getBalanceStatement("UNO", "Sumit", 5);
        assertEquals(balanceStatement, "UNO Sumit 2000 50");
    }

    @Test
    void getBalanceStatement() {
        // create loans with various banks and users
        ledger.createLoan("UNO", "Sumit", 10000, 5, 4);
        ledger.createLoan("IDIDI", "Sumit", 20000, 4, 5);
        ledger.createLoan("HDFC", "Sanjana", 50000, 3, 6);
        ledger.createLoan("UNO", "Aniket", 60000, 6, 3);

        // process payments
        ledger.processPayment("UNO", "Sumit", 1000, 5);
        ledger.processPayment("UNO", "Aniket", 1000, 5);
        ledger.processPayment("IDIDI", "Sumit", 1000, 5);

        // check balance statement
        String balanceStatement = ledger.getBalanceStatement("UNO", "Sumit", 5);
        assertEquals(balanceStatement, "UNO Sumit 2000 50");
    }

    @AfterEach
    public void tearDown(){
        ledger = null;
    }
}
package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class Ledger {
    Map<String, Bank> bankNameToBankMap = new HashMap<>();

    /*
     There are three services offered by Ledger Corporation
     Loan Creation
     Payment
     Balance
    */

    private Bank getBank(String bankName){
        // get the bank
        Bank bank = bankNameToBankMap.get(bankName);
        // create new bank if not exist
        // This will be in accordance with Ledger's company policy. My assumption is to create the bank if not exist.
        if(bank == null) {
            bank = new Bank(bankName);
            bankNameToBankMap.put(bankName, bank);
        }
        return bank;
    }

    // Loan Creation
    public void createLoan(String bankName, String userName, long amount, int numberOfYears, float rateOfInterest) {
        // get the bank
        Bank bank = getBank(bankName);
        // create loan
        bank.createLoan(userName, amount, numberOfYears, rateOfInterest);
    }

    // Payment
    public void processPayment(String bankName, String userName, long lumpSum, int emiSequence){
        // get the bank
        Bank bank = getBank(bankName);
        // process the Payment
        bank.processPayment(userName, lumpSum, emiSequence);
    }

    // Balance
    public String getBalanceStatement(String bankName, String userName, int emiSequence){
        // get the bank
        Bank bank = getBank(bankName);
        // get amount paid
        long amountPaid = bank.getAmountPaid(userName, emiSequence);
        // get EMIs remaining
        int numberOfRemainingEmi = bank.getNumberOfRemainingEmi(userName, emiSequence);
        // format the balance statement and return
        return String.format("%s %s %d %d", bankName, userName, amountPaid, numberOfRemainingEmi);
    }
}

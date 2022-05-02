package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class Ledger {
    private static final Map<String, Bank> bankNameToBankMap = new HashMap<>();
    private static final Map<String, User> userNameToUserMap = new HashMap<>();

    private static User getUser(String userName){
        // get the user
        User user = userNameToUserMap.get(userName);
        // create new user if not exist
        // This will be in accordance with Ledger's company policy. My assumption is to create the user if not exist.
        if(user == null) {
            user = new User(userName);
            userNameToUserMap.put(userName, user);
        }
        return user;
    }

    private static Bank getBank(String bankName){
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

    /*
     There are three services offered by Ledger Corporation
     Loan Creation
     process Payment
     Balance statement
    */


    // Loan Creation
    public static void createLoan(String bankName, String userName, long amount, int numberOfYears, float rateOfInterest) {
        // get the bank
        Bank bank = getBank(bankName);
        // get the user
        User user = getUser(userName);
        // create loan
        bank.createLoan(user, amount, numberOfYears, rateOfInterest);
    }

    // process Payment
    public static void processPayment(String bankName, String userName, long lumpSum, int emiSequence){
        // get the bank
        Bank bank = getBank(bankName);
        // get the user
        User user = getUser(userName);
        // process the Payment
        bank.processPayment(user, lumpSum, emiSequence);
    }

    // Balance statement
    public static String getBalanceStatement(String bankName, String userName, int emiSequence){
        // get the bank
        Bank bank = getBank(bankName);
        // get the user
        User user = getUser(userName);
        // get amount paid
        long amountPaid = bank.getAmountPaid(user, emiSequence);
        // get EMIs remaining
        int numberOfRemainingEmi = bank.getNumberOfRemainingEmi(user, emiSequence);
        // format the balance statement and return
        return String.format("%s %s %d %d", bankName, userName, amountPaid, numberOfRemainingEmi);
    }
}

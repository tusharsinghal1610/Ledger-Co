package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private final Map<String,User> userNameToUserMap;

    Bank(String name){
        this.name = name;
        this.userNameToUserMap = new HashMap<>();
    }

    private User getUser(String userName){
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

    // get Loan for a User
    public void createLoan(String userName, long amount, int numberOfYears, float rateOfInterest){
        // get the user
        User user = getUser(userName);
        // get loan for user
        user.createLoan(amount, numberOfYears, rateOfInterest);
    }

    // payments
    public void processPayment(String userName, long lumpSum, int emiSequence){
        // get the user
        User user = getUser(userName);
        // process the Payment
        user.processPayment(lumpSum, emiSequence);
    }

    // Returns the amount paid in total till {emiSequence} of EMIs are paid with any lump sum amount if any
    public long getAmountPaid(String userName, int emiSequence){
        // get the user
        User user = getUser(userName);
        // get the amount paid
        return user.getAmountPaid(emiSequence);
    }

    // Returns the number of EMI's remaining after {emiSequence} of EMIs are paid with any lump sum amount if any.
    public int getNumberOfRemainingEmi(String userName, int emiSequence){
        // get the user
        User user = getUser(userName);
        // get Number Of Remaining Emis
        return user.getNumberOfRemainingEmi(emiSequence);
    }

}

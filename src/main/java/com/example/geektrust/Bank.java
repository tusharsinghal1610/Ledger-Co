package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private final Map<User,Loan> userToLoanMap;

    Bank(String name){
        this.name = name;
        this.userToLoanMap = new HashMap<>();
    }

    // get assigned loan
    private Loan getLoanByUser(User user){
        return userToLoanMap.get(user);
    }

    // get Loan for a User
    public void createLoan(User user, long amount, int numberOfYears, float rateOfInterest){
        // create loan for user
        Loan loan = new Loan(amount, numberOfYears, rateOfInterest);
        // assign the loan to user
        this.userToLoanMap.put(user, loan);
    }

    // payments
    public void processPayment(User user, long lumpSum, int emiSequence){
        // get the user's loan
        Loan loan = this.getLoanByUser(user);
        // process the Payment
        loan.processPayment(lumpSum, emiSequence);
    }

    // Returns the amount paid in total till {emiSequence} of EMIs are paid with any lump sum amount if any
    public long getAmountPaid(User user, int emiSequence){
        // get the user's laon
        Loan loan = this.getLoanByUser(user);
        // get the amount paid
        return loan.getAmountPaid(emiSequence);
    }

    // Returns the number of EMI's remaining after {emiSequence} of EMIs are paid with any lump sum amount if any.
    public int getNumberOfRemainingEmi(User user, int emiSequence){
        // get the user's loan
        Loan loan = this.getLoanByUser(user);
        // get Number Of Remaining Emis
        return loan.getNumberOfRemainingEmi(emiSequence);
    }

}

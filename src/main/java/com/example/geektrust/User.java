package com.example.geektrust;

public class User {
    String name;
    Loan loan;

    User(String name){
        this.name = name;
        this.loan = null;
    }

    // Gives the loan to user
    public void createLoan(long amount, int numberOfYears, float rateOfInterest) {
        this.loan = new Loan(amount, numberOfYears, rateOfInterest);
    }

    // process the payment made towards a loan
    public void processPayment(long lumpSum, int emiSequence){
        // If no loan is given
        if(this.loan == null) throw new IllegalStateException("No loan exists for the user " + this.name);
        // if loan is given in past
        this.loan.processPayment(lumpSum, emiSequence);
    }

    // Returns the amount paid in total till {emiSequence} of EMIs are paid with any lump sum amount if any
    public long getAmountPaid(int emiSequence){
        // get the amount paid
        return this.loan.getAmountPaid(emiSequence);
    }

    // Returns the number of EMI's remaining after {emiSequence} of EMIs are paid with any lump sum amount if any.
    public int getNumberOfRemainingEmi(int emiSequence){
        // get Number Of Remaining Emis
        return this.loan.getNumberOfRemainingEmi(emiSequence);
    }
}

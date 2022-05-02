package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.ceil;

public class Loan {

    long principalAmount;
    float rateOfInterest;
    int tenureInYears;
    float totalAmountToRepay;
    long emiAmount;
    List<LumpSum> lumpSums;

    Loan(long principalAmount, int numberOfYears, float rateOfInterest){
        this.principalAmount = principalAmount;
        this.rateOfInterest = rateOfInterest;
        this.tenureInYears = numberOfYears;
        this.totalAmountToRepay = principalAmount + principalAmount*rateOfInterest * this.tenureInYears/100;
        this.emiAmount = (long) ceil(this.totalAmountToRepay /(this.tenureInYears*12));
        this.lumpSums = new ArrayList<>();
    }

    // Returns the total lump sum amount paid till the given emi sequence including it
    private long getTotalLumpSumPaidTillEmi(int emiSequence){
        // sum of lump sum which are paid with emi sequence less than or equal to emiSequence
        return lumpSums.stream()
                .filter(lumpSum -> lumpSum.getEmiSequence()<=emiSequence)
                .mapToLong(LumpSum::getAmount).sum();
    }

    // Returns the amount paid till the given emi sequence including it
    private long getTotalAmountPaidAsEmi(int emiSequence){
        return this.emiAmount*emiSequence;
    }

    // adds the lumpsum given the given emi sequence
    public void processPayment(long lumpSum, int emiSequence){
        lumpSums.add(new LumpSum(lumpSum, emiSequence));
    }

    // Returns the amount paid in total till {emiSequence} of EMIs are paid with any lump sum amount if any
    public long getAmountPaid(int emiSequence){
        // sum of lumpsums and emi amount paid
        long totalLumpSum = this.getTotalLumpSumPaidTillEmi(emiSequence);
        long totalEmiAmountPaid = this.getTotalAmountPaidAsEmi(emiSequence);
        return totalLumpSum + totalEmiAmountPaid;

    }

    // Returns the number of EMI's remaining after {emiSequence} of EMIs are paid with any lump sum amount if any.
    public int getNumberOfRemainingEmi(int emiSequence){
        // get Remaining amount to be paid
        long totalAmountPaid = this.getAmountPaid(emiSequence);
        float remainingAmountToRepay = this.totalAmountToRepay-totalAmountPaid;
        return (int) ceil(remainingAmountToRepay/this.emiAmount);
    }

}

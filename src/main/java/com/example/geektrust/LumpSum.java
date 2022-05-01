package com.example.geektrust;

public class LumpSum {
    long amount;
    int emiSequence; // this field represents emi sequence with which lumpsum was given

    LumpSum(long amount, int emiSequence){
        this.amount = amount;
        this.emiSequence = emiSequence;
    }

    public long getAmount(){
        return this.amount;
    }

    public int getEmiSequence(){
        return this.emiSequence;
    }
}

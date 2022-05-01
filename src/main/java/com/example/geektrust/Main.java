package com.example.geektrust;

import java.io.*;

public class Main {

    public static void main(String[] args)  {
        try{
            // check if file is specified otherwise return
            if (args.length < 1) {
                System.out.println("No input file");
                System.out.println("Usage: java Geektrust 'input.txt'");
                return;
            }

            // initialize Ledger
            Ledger ledger = new Ledger();

            // read the input from a text file
            File file = new File(args[0]);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String inputLine;
            // process for each line in input file
            while ((inputLine = bufferedReader.readLine()) != null) {
                // split input line using space as delimiter
                String[] inputs = inputLine.split(" ");
                String inputCommand = inputs[0];
                String bankName = inputs[1];
                String borrowerName = inputs[2];
                int emiSequence;
                // execute requests based on inputCommand
                switch (inputCommand){
                    case "LOAN":
                        long principalAmount = Long.parseLong(inputs[3]);
                        int numberOfYears = Integer.parseInt(inputs[4]);
                        float rateOfInterest = Float.parseFloat(inputs[5]);
                        ledger.createLoan(bankName, borrowerName, principalAmount, numberOfYears, rateOfInterest);
                        break;
                    case "PAYMENT":
                        long lumpSumAmount = Long.parseLong(inputs[3]);
                        emiSequence = Integer.parseInt(inputs[4]);
                        ledger.processPayment(bankName, borrowerName, lumpSumAmount, emiSequence);
                        break;
                    case "BALANCE":
                        emiSequence = Integer.parseInt(inputs[3]);
                        System.out.println(ledger.getBalanceStatement(bankName, borrowerName, emiSequence));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input command " + inputCommand);
                }
            }
        }catch (Exception exception){
            System.out.println("Exception while processing " + exception);
        }
    }
}

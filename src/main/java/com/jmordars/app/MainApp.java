package com.jmordars.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.io.File;

import com.jmordars.app.StateSeatPair;

public class MainApp {
    public static void main(String[] args) {
        HuntingtonHill hh = new HuntingtonHill();

        int numberOfSeats = 435;

        if (args.length > 0) {
            numberOfSeats = Integer.parseInt(args[0]);
        }

        // run Huntington-Hill
        StateSeatPair[] seatList = hh.runHuntingtonHill(numberOfSeats);

        // Print results
        for (int i = 0; i < seatList.length; ++i) {
            StateSeatPair current = seatList[i];
            System.out.println(current.getState().getName() + ": " + current.getSeats() + " Pop ratio: "
                    + Math.round(current.getPopToRepRatio()));
        }

        // calculate final total of seats
        int finalTotal = 0;
        for (int i = 0; i < seatList.length; ++i) {
            finalTotal += seatList[i].getSeats();
        }

        System.out.println("Final number of seats: " + finalTotal);

        // calculate final population total
        int totalUSPopulation = 0;
        State[] states = hh.getStates();
        for (int i = 0; i < states.length; ++i) {
            totalUSPopulation += states[i].getPopulation();
        }
        System.out.println("Total Population: " + totalUSPopulation);

        // TODO: hacky way to do this, but can't figure out how to bring in non maven
        // submodules.  Bring in targets/switches lib 

        if(args.length > 1) {
            // benchmark test, check to see if we want to do it or not
            if(Boolean.parseBoolean(args[1]))
            {
                // perform timed tests
                long startTime;
                long finishTime;
                for(int i = 0; i < 29; ++i)
                {
                    startTime = System.currentTimeMillis();
                    seatList = hh.runHuntingtonHill(50 + (int)Math.pow(2, i));
                    finishTime = System.currentTimeMillis();
                    System.out.println("Time taken for " + i + " " + (finishTime - startTime) + " milliseconds");
                }
            }
        }

        // TODO: Fix the hack
        if(args.length > 2) {
            // arg 2 is the number of seats to run the calculations on

            // number of data points to get variance of
            int varianceCalculations = Integer.parseInt(args[2]);
            // run a few more times and put the data out to file
            File file = new File("variance_output_" + System.currentTimeMillis() + ".xls");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for(int i = 50; i < varianceCalculations; ++i)
                {
                    // base case of 50 and iterate through
                    seatList = hh.runHuntingtonHill(i);
                    double[] popRatios = StateSeatPair.toDouble(seatList);
                    bw.write(i + ", " + hh.calculateVariance(popRatios) + "\r");

                    // Something to watch, to see if we're still calculating
                    System.out.println("i value: " + i);
                }

                bw.flush();
                bw.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
}

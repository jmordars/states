package com.jmordars.app;

public class MainApp {
    public static void main(String[] args) {
        HuntingtonHill hh = new HuntingtonHill();

        int numberOfSeats = 435;

        if(args.length > 0)
        {
            numberOfSeats = Integer.parseInt(args[0]);
        }

        // run Huntington-Hill
        StateSeatPair[] seatList = hh.runHuntingtonHill(numberOfSeats);

        // Print results
        for (int i = 0; i < seatList.length; ++i) {
            StateSeatPair current = seatList[i];
            System.out.println(
                    "State: " + current.getState().getName() + "\tNumber of Seats: " + current.getSeats());
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
            totalUSPopulation += states[i].getPopulation2010();
        }
        System.out.println("Total Population: " + totalUSPopulation);

    }
}

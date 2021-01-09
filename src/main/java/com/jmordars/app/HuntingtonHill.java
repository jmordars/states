package com.jmordars.app;

class HuntingtonHill {
    private State[] mStates;
    private final static int NUM_OF_SEATS_TOTAL = 435;

    public HuntingtonHill() {
        // create an array of 50 states
        mStates = new State[50];
        populateAndAddStates(0);
    }

    public State[] getStates() {
        return mStates;
    }

    public int getTotalSeats() {
        return NUM_OF_SEATS_TOTAL;
    }

    public StateSeatPair[] runHuntingtonHill() {
        // use polymorphism to use default value of seats
        return runHuntingtonHill(NUM_OF_SEATS_TOTAL);
    }

    public StateSeatPair[] runHuntingtonHill(long totalNumberOfSeats) throws ArithmeticException {
        // The total number of seats needs to be at least 50
        if (50 > totalNumberOfSeats) {
            throw new ArithmeticException("Must allocate at least 1 seat per state");
        }

        // Go through the list of states, and assign each state
        // one seat -- then calculate priorities, and iterate
        // through the list of states and add new seats to the
        // highest priority seat.
        StateSeatPair[] seatList = new StateSeatPair[50];
        for (int i = 0; i < 50; ++i) {
            // give every state an initial representative
            seatList[i] = new StateSeatPair(mStates[i]);
            seatList[i].addSeat();
        }

        // each state has one seat -- fill the remaining seats

        for (int i = 0; i < totalNumberOfSeats - seatList.length; ++i) {
            // add available seats
            for (int j = 0; j < seatList.length; ++j) {
                // calculate priorities
                StateSeatPair current = seatList[j];
                current.setPriority(calculatePriority(current.getState().getPopulation(), current.getSeats() + 1));
            }

            // get the highest priority
            double highestPrioritySatePriority = seatList[0].getPriority();
            StateSeatPair getsASeat = seatList[0];
            for (int j = 0; j < seatList.length; ++j) {
                StateSeatPair current = seatList[j];
                // check for highest priority
                if (current.getPriority() > highestPrioritySatePriority) {
                    highestPrioritySatePriority = current.getPriority();
                    getsASeat = current;
                }
            }
            getsASeat.addSeat();
        }

        // print results

        return seatList;
    }

    public double calculatePriority(int population, int seats) {
        // priority is determined by Population
        return (population * (1 / java.lang.Math.sqrt(seats * (seats - 1))));
    }

    public double calculateTotalSeats(int population) {
        return java.lang.Math.cbrt(population);
    }

    public double calculateVariance(double[] values)
    {
        // first calculate the mean of the values
        double step1 = 0;
        for(int i = 0; i < values.length; ++i)
        {
            step1 += values[i];
        }

        // square the total and divide by sum
        double step2 = (Math.pow(step1, 2) / values.length);

        // take original set of numbers, square individually and add up
        double step3 = 0;
        for(int i = 0; i < values.length; ++i)
        {
            step3 += Math.pow(values[i], 2);
        }

        // subtract the amount in step two from step 3
        double step4 = step3 - step2;

        double step5 = values.length - 1;

        return (step4 / step5);
    }

    private void populateAndAddStates(int year) {
        // adding populations from Wikipedia

        if(year == 2020) {
            // 2020 populations
            mStates[0] = new State("Alabama", 4903185);
            mStates[1] = new State("Alaska", 731545);
            mStates[2] = new State("Arizona", 7278717);
            mStates[3] = new State("Arkansas", 3017804);
            mStates[4] = new State("California", 39512223);
            mStates[5] = new State("Colorado", 5758736);
            mStates[6] = new State("Connecticut", 3565287);
            mStates[7] = new State("Delaware", 973764);
            mStates[8] = new State("Florida", 21477737);
            mStates[9] = new State("Georgia", 10617423);
            mStates[10] = new State("Hawaii", 1415872);
            mStates[11] = new State("Idaho", 1787065);
            mStates[12] = new State("Illinois", 12671821);
            mStates[13] = new State("Indiana", 6732219);
            mStates[14] = new State("Iowa", 3155070);
            mStates[15] = new State("Kansas", 2913314);
            mStates[16] = new State("Kentucky", 4467673);
            mStates[17] = new State("Louisiana", 4648794);
            mStates[18] = new State("Maine", 1344212);
            mStates[19] = new State("Maryland", 6045680);
            mStates[20] = new State("Massachusetts", 689503);
            mStates[21] = new State("Michigan", 9986857);
            mStates[22] = new State("Minnesota", 5639632);
            mStates[23] = new State("Mississippi", 2976149);
            mStates[24] = new State("Missouri", 6137428);
            mStates[25] = new State("Montana", 1068778);
            mStates[26] = new State("Nebraska", 1934408);
            mStates[27] = new State("Nevada", 3080156);
            mStates[28] = new State("New Hampshire", 1359711);
            mStates[29] = new State("New Jersey", 8882190);
            mStates[30] = new State("New Mexico", 2096829);
            mStates[31] = new State("New York", 19453561);
            mStates[32] = new State("North Carolina", 10488084);
            mStates[33] = new State("North Dakota", 762062);
            mStates[34] = new State("Ohio", 11689100);
            mStates[35] = new State("Oklahoma", 3956971);
            mStates[36] = new State("Oregon", 4217737);
            mStates[37] = new State("Pennsylvania", 12801989);
            mStates[38] = new State("Rhode Island", 1059361);
            mStates[39] = new State("South Carolina", 5148714);
            mStates[40] = new State("South Dakota", 884659);
            mStates[41] = new State("Tennessee", 6829174);
            mStates[42] = new State("Texas", 28995881);
            mStates[43] = new State("Utah", 3205958);
            mStates[44] = new State("Vermont", 623989);
            mStates[45] = new State("Virginia", 8535519);
            mStates[46] = new State("Washington", 7614893);
            mStates[47] = new State("West Virginia", 1792147);
            mStates[48] = new State("Wisconsin", 5822434);
            mStates[49] = new State("Wyoming", 578759);
        }
        else {
            // Census Population -- for 2010
            mStates[0] = new State("Alabama", 4802982);
            mStates[1] = new State("Alaska", 721523);
            mStates[2] = new State("Arizona", 6412700);
            mStates[3] = new State("Arkansas", 2926229);
            mStates[4] = new State("California", 37341989);
            mStates[5] = new State("Colorado", 5044930);
            mStates[6] = new State("Connecticut", 3581628);
            mStates[7] = new State("Delaware", 900877);
            mStates[8] = new State("Florida", 18900773);
            mStates[9] = new State("Georgia", 9727566);
            mStates[10] = new State("Hawaii", 1366862);
            mStates[11] = new State("Idaho", 1573499);
            mStates[12] = new State("Illinois", 12864380);
            mStates[13] = new State("Indiana", 6501582);
            mStates[14] = new State("Iowa", 3053787);
            mStates[15] = new State("Kansas", 2863813);
            mStates[16] = new State("Kentucky", 4350606);
            mStates[17] = new State("Louisiana", 4553962);
            mStates[18] = new State("Maine", 1333074);
            mStates[19] = new State("Maryland", 5789929);
            mStates[20] = new State("Massachusetts", 6559644);
            mStates[21] = new State("Michigan", 9911626);
            mStates[22] = new State("Minnesota", 5314879);
            mStates[23] = new State("Mississippi", 2978240);
            mStates[24] = new State("Missouri", 6011478);
            mStates[25] = new State("Montana", 994416);
            mStates[26] = new State("Nebraska", 1831825);
            mStates[27] = new State("Nevada", 2709432);
            mStates[28] = new State("New Hampshire", 1321445);
            mStates[29] = new State("New Jersey", 8807501);
            mStates[30] = new State("New Mexico", 2067273);
            mStates[31] = new State("New York", 19421055);
            mStates[32] = new State("North Carolina", 9565781);
            mStates[33] = new State("North Dakota", 675905);
            mStates[34] = new State("Ohio", 11568495);
            mStates[35] = new State("Oklahoma", 3764882);
            mStates[36] = new State("Oregon", 3848606);
            mStates[37] = new State("Pennsylvania", 12734905);
            mStates[38] = new State("Rhode Island", 1055247);
            mStates[39] = new State("South Carolina", 4645975);
            mStates[40] = new State("South Dakota", 819761);
            mStates[41] = new State("Tennessee", 6375431);
            mStates[42] = new State("Texas", 25268418);
            mStates[43] = new State("Utah", 2770765);
            mStates[44] = new State("Vermont", 630337);
            mStates[45] = new State("Virginia", 8037736);
            mStates[46] = new State("Washington", 6753369);
            mStates[47] = new State("West Virginia", 1859815);
            mStates[48] = new State("Wisconsin", 5698230);
            mStates[49] = new State("Wyoming", 568300);
        }
    }
}
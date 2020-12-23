package com.jmordars.app;

class HuntingtonHill {
    private State[] mStates;
    private final static int NUM_OF_SEATS_TOTAL = 435;

    public HuntingtonHill() {
        // create an array of 50 states
        mStates = new State[50];
        populateAndAddStates();
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
                current.setPriority(calculatePriority(current.getState().getPopulation2010(), current.getSeats() + 1));
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

    private void populateAndAddStates() {
        // adding populations from Wikipedia
        // Census Population -- July 1, 2019
        mStates[0] = new State("Alabama", 4802982, 4903185, true);
        mStates[1] = new State("Alaska", 721523, 731545, true);
        mStates[2] = new State("Arizona", 6412700, 7278717, true);
        mStates[3] = new State("Arkansas", 2926229, 3017804, true);
        mStates[4] = new State("California", 37341989, 39512223, true);
        mStates[5] = new State("Colorado", 5044930, 5758736, true);
        mStates[6] = new State("Connecticut", 3581628, 3565287, true);
        mStates[7] = new State("Delaware", 900877, 973764, true);
        // mStates[x] = (new State("District of Columbia", 601723,705749, false));
        mStates[8] = new State("Florida", 18900773, 21477737, true);
        mStates[9] = new State("Georgia", 9727566, 10617423, true);
        mStates[10] = new State("Hawaii", 1366862, 1415872, true);
        mStates[11] = new State("Idaho", 1573499, 1787065, true);
        mStates[12] = new State("Illinois", 12864380, 12671821, true);
        mStates[13] = new State("Indiana", 6501582, 6732219, true);
        mStates[14] = new State("Iowa", 3053787, 3155070, true);
        mStates[15] = new State("Kansas", 2863813, 2913314, true);
        mStates[16] = new State("Kentucky", 4350606, 4467673, true);
        mStates[17] = new State("Louisiana", 4553962, 4648794, true);
        mStates[18] = new State("Maine", 1333074, 1344212, true);
        mStates[19] = new State("Maryland", 5789929, 6045680, true);
        mStates[20] = new State("Massachusetts", 6559644, 689503, true);
        mStates[21] = new State("Michigan", 9911626, 9986857, true);
        mStates[22] = new State("Minnesota", 5314879, 5639632, true);
        mStates[23] = new State("Mississippi", 2978240, 2976149, true);
        mStates[24] = new State("Missouri", 6011478, 6137428, true);
        mStates[25] = new State("Montana", 994416, 1068778, true);
        mStates[26] = new State("Nebraska", 1831825, 1934408, true);
        mStates[27] = new State("Nevada", 2709432, 3080156, true);
        mStates[28] = new State("New Hampshire", 1321445, 1359711, true);
        mStates[29] = new State("New Jersey", 8807501, 8882190, true);
        mStates[30] = new State("New Mexico", 2067273, 2096829, true);
        mStates[31] = new State("New York", 19421055, 19453561, true);
        mStates[32] = new State("North Carolina", 9565781, 10488084, true);
        mStates[33] = new State("North Dakota", 675905, 762062, true);
        mStates[34] = new State("Ohio", 11568495, 11689100, true);
        mStates[35] = new State("Oklahoma", 3764882, 3956971, true);
        mStates[36] = new State("Oregon", 3848606, 4217737, true);
        mStates[37] = new State("Pennsylvania", 12734905, 12801989, true);
        mStates[38] = new State("Rhode Island", 1055247, 1059361, true);
        mStates[39] = new State("South Carolina", 4645975, 5148714, true);
        mStates[40] = new State("South Dakota", 819761, 884659, true);
        mStates[41] = new State("Tennessee", 6375431, 6829174, true);
        mStates[42] = new State("Texas", 25268418, 28995881, true);
        mStates[43] = new State("Utah", 2770765, 3205958, true);
        mStates[44] = new State("Vermont", 630337, 623989, true);
        mStates[45] = new State("Virginia", 8037736, 8535519, true);
        mStates[46] = new State("Washington", 6753369, 7614893, true);
        mStates[47] = new State("West Virginia", 1859815, 1792147, true);
        mStates[48] = new State("Wisconsin", 5698230, 5822434, true);
        mStates[49] = new State("Wyoming", 568300, 578759, true);
    }
}
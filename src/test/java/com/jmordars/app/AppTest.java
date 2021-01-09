package com.jmordars.app;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHuntingtonHill()
    {
        HuntingtonHill hh = new HuntingtonHill();
        
        // run with 50 states for now hard coded
        assertEquals(50, hh.getStates().length);

        assertEquals(435, hh.getTotalSeats());

        StateSeatPair[] seatList = hh.runHuntingtonHill();

        // actual counts 
        int[] actualSeatCounts = {7, 1, 9, 4, 53, 7, 5, 1, 27, 14, 
                                       2, 2, 18, 9, 4, 4, 6, 6, 2, 8, 
                                       9, 14, 8, 4, 8, 1, 3, 4, 2, 12, 
                                       3, 27, 13, 1, 16, 5, 5, 18, 2, 7,
                                       1, 9, 36, 4, 1, 11, 10, 3, 8, 1};

        // compare seats with nominal run against actuals
        for(int i = 0; i < actualSeatCounts.length; ++i)
        {
            assertEquals(actualSeatCounts[i], seatList[i].getSeats());
        }

        assertEquals((100 / java.lang.Math.sqrt(90)), hh.calculatePriority(100, 10), 0);

        assertEquals(3, hh.calculateTotalSeats(27), 0);

        // test variance with 20 values
        double[] testList = new double[20];
        for(int i = 0; i < testList.length; ++i)
        {
            testList[i] = i;
        }

        double variance = hh.calculateVariance(testList);
        assertEquals(35, variance, 0);
    }

    @Test
    public void testState()
    {
        // Verify Constructor
        State state = new State("test", 1);
        assertEquals(1, state.getPopulation());
        assertEquals("test", state.getName());
    }

    @Test
    public void testStateSeatPair()
    {
        State state = new State("test", 1);
        StateSeatPair ssp = new StateSeatPair(state);
        assertEquals(0, ssp.getSeats());
        assertTrue(state.equals(ssp.getState()));
        assertEquals(0, ssp.getPriority(), 0);
        ssp.addSeat();
        assertEquals(1, ssp.getSeats());
        assertEquals(1, ssp.getPopToRepRatio(), 0);
        ssp.addSeat();
        assertEquals(.5, ssp.getPopToRepRatio(), 0);
        ssp.setPriority(42.69);
        assertEquals(42.69, ssp.getPriority(), 0);

        // test pop ratio list to list of ints
        StateSeatPair[] seatList = new StateSeatPair[1];
        seatList[0] = ssp;
        double[] testList = StateSeatPair.toDouble(seatList);

        assertEquals(testList[0], ssp.getPopToRepRatio(), 0);
    }
}

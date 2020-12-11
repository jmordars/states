package com.jmordars.app;

public class StateSeatPair {
    private State mState;
    private int mSeats;
    private double mPriority;

    public StateSeatPair(State state) {
        mState = state;
        mSeats = 0;
        mPriority = 0;
    }

    public void addSeat() {
        ++mSeats;
    }

    public int getSeats() {
        return mSeats;
    }

    public void setPriority(double priority) {
        mPriority = priority;
    }

    public double getPriority() {
        return mPriority;
    }

    public State getState() {
        return mState;
    }

    public double getPopToRepRatio()
    {
        return (double) mState.getPopulation2010() / mSeats;
    }
}

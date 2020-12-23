package com.jmordars.app;

import lombok.Getter;

@Getter
public class StateSeatPair {
    private State state;
    private int seats;
    private double priority;

    public StateSeatPair(State state) {
        this.state = state;
        seats = 0;
        priority = 0;
    }

    public void addSeat() {
        ++seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public double getPopToRepRatio()
    {
        return (double) state.getPopulation2010() / seats;
    }
}


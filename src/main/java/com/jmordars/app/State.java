package com.jmordars.app;

class State {
    private int mPopulation2010 = 0;
    private int mPopulation2019 = 0;
    private String mName;
    private boolean mHasSenators = true;

    public State(String name, int population2010, int population2019, boolean hasSenators)
    {
        mName = name;
        mPopulation2010 = population2010;
        mPopulation2019 = population2019;
        mHasSenators = hasSenators;
    }

    public int getPopulation2010()
    {
        return mPopulation2010;
    }

    public int getPopulation2019()
    {
        return mPopulation2019;
    }

    public String getName()
    {
        return mName;
    }

    public boolean hasSenators()
    {
        return mHasSenators;
    }
}

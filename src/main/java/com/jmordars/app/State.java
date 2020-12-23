package com.jmordars.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class State {
    private String name;
    private int population2010 = 0;
    private int population2019 = 0;
    private boolean hasSenators = true;

    public boolean hasSenators() {
        return hasSenators;
    }
}

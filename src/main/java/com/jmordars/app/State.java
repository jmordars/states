package com.jmordars.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class State {
    private String name;
    private int population = 0;
}

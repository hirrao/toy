package com.hirrao.rockpaperscissors.mode;

public class Random extends Mode {
    public Random() {
        super();
        action = ActionType.values()[(int) (Math.random() * 3) + 1];
    }
}

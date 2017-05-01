package com.github.cc007.royalgameofur.model;

/**
 * Created by Rik on 29-4-2017.
 */
public class Turn {
    private final boolean successfull;
    private final boolean reroll;

    public Turn(boolean successfull, boolean reroll) {
        this.successfull = successfull;
        this.reroll = reroll;
    }

    public boolean isSuccessfull() {
        return successfull;
    }

    public boolean isReroll() {
        return reroll;
    }
}

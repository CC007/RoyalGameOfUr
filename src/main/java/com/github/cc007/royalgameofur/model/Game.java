package com.github.cc007.royalgameofur.model;

import java.util.Random;

/**
 * Created by Rik on 29-4-2017.
 */
public class Game {

    public int rollDice() {
        Random r = new Random(System.nanoTime());
        return r.nextInt(1) + r.nextInt(1) + r.nextInt(1) + r.nextInt(1);
    }
}

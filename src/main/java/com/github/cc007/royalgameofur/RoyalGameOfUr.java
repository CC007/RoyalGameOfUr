package com.github.cc007.royalgameofur;

/**
 * Created by Rik on 29-4-2017.
 */
public class RoyalGameOfUr {
    public static void main(String[] args) {
        View view = null;
        Game game = new Game(view);
        new Thread(game, "RoyalGameOfUr").start();
    }
}

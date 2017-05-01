package com.github.cc007.royalgameofur;

import com.github.cc007.royalgameofur.model.Board;
import com.github.cc007.royalgameofur.model.Move;
import com.github.cc007.royalgameofur.model.Players;
import com.github.cc007.royalgameofur.model.Turn;

import java.util.Random;

/**
 * Created by Rik on 29-4-2017.
 */
public class Game implements Runnable {

    private Board board;
    private View view;
    private boolean ended;
    private Players currentPlayer;

    public Game(View view) {
        this.board = new Board();
        this.ended = false;
        this.view = view;
    }

    @Override
    public void run() {
        view.init(board);
        while (!ended) {
            boolean reroll = doHalfTurn();
            if (!reroll) {
                currentPlayer = currentPlayer.getOtherPlayer();
            }
        }
    }

    private boolean doHalfTurn() {
        boolean reroll = false;
        boolean successfullMove = false;
        view.setValue("roll", currentPlayer);
        int rollValue = rollDice();
        view.setValue("rollValue", rollValue);
        if (currentPlayer.getPlayer().canMove(board, rollValue)) {
            Turn turn = null;
            while (!successfullMove) {
                Move move = view.getValue("move", Move.class);
                if (move.isNewPiece()) {
                    if (!currentPlayer.getPlayer().hasUnusedPieces()) {
                        view.waitUntil("illegalMove");
                        continue;
                    }
                    turn = currentPlayer.getPlayer().moveUnusedPiece(rollValue);

                } else {
                    if (move.getMoveFromTile().getPiece() == null || move.getMoveFromTile().getPiece().getPlayer() != currentPlayer.getPlayer()) {
                        view.waitUntil("illegalMove");
                        continue;
                    }
                    turn = currentPlayer.getPlayer().moveFromTile(move.getMoveFromTile(), rollValue);
                }
                successfullMove = turn.isSuccessfull();
            }
            reroll = turn.isReroll();
        } else {
            view.waitUntil("cannotMove");
        }
        view.setValue("Reroll", true);
        return reroll;
    }

    public int rollDice() {
        Random r = new Random(System.nanoTime());
        return r.nextInt(1) + r.nextInt(1) + r.nextInt(1) + r.nextInt(1);
    }
}

package com.github.cc007.royalgameofur.model;

import com.github.cc007.royalgameofur.model.tiles.Tile;
import com.github.cc007.royalgameofur.model.tiles.Turn;

import java.util.Stack;

/**
 * Created by Rik on 29-4-2017.
 */
public enum Players {
    PLAYER1(new Player()),
    PLAYER2(new Player());

    private Player player;

    Players(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public static class Player {
        private Stack<Piece> unusedPieces;
        private Stack<Piece> finishedPieces;
        private Tile firstTile;
        private Tile lastTile;

        public Player() {
            this.unusedPieces = new Stack<>();
            this.finishedPieces = new Stack<>();
            for (int i = 0; i < 7; i++) {
                this.unusedPieces.push(new Piece());
            }
        }
        public void setFirstTile(Tile tile) {
            this.firstTile = tile;
        }
        public void setLastTile(Tile tile) {
            this.lastTile = tile;
        }

        public boolean hasUnusedPieces() {
            return unusedPieces.size() != 0;
        }

        public void moveUnusedPiece(int count) {
            Piece piece = unusedPieces.pop();
            Tile newTile = firstTile;
            for (int i = 0; i < count - 1; i++) {
                newTile = newTile.getNext(this);
            }
            move(piece, firstTile, newTile);
        }

        public boolean containsPlayerPiece(Tile tile){
            return tile.getPiece().getPlayer().equals(this);
        }

        public void moveFromTile(Tile oldTile, int count) {
            Piece piece = oldTile.getPiece();
            Tile newTile = oldTile;
            for (int i = 0; i < count; i++) {
                newTile = newTile.getNext(this);
            }
            move(piece, oldTile, newTile);
        }

        private void move(Piece piece, Tile oldTile, Tile newTile) {
            Turn turn = newTile.onEnter(piece, oldTile);
        }

        public void returnPiece(Piece piece) {
            unusedPieces.push(piece);
        }

    }


}

package com.github.cc007.royalgameofur.model;

import com.github.cc007.royalgameofur.model.tiles.Tile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

    public Players getOtherPlayer() {
        return this == PLAYER1 ? PLAYER2 : PLAYER1;
    }

    public Player getPlayer() {
        return player;
    }

    public static class Player {
        private Stack<Piece> unusedPieces;
        private Set<Piece> finishedPieces;
        private Tile firstTile = null;
        private Tile lastTile = null;

        public Player() {
            this.unusedPieces = new Stack<>();
            this.finishedPieces = new HashSet<>();
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

        public Tile getNthTile(Tile tile, int count) {
            for (int i = count; i > 0; i--) {
                if (!tile.hasNext(this)) {
                    return null;
                }
                tile = tile.getNext(this);
            }
            return tile;
        }

        public boolean hasNthTile(Tile tile, int count) {
            for (int i = count; i > 1; i--) {
                if (!tile.hasNext(this)) {
                    return false;
                }
                tile = tile.getNext(this);
            }
            return true;
        }

        public boolean hasUnusedPieces() {
            return unusedPieces.size() != 0;
        }

        public Turn moveUnusedPiece(int count) {
            Piece piece = unusedPieces.pop();
            Tile newTile = getNthTile(firstTile, count - 1);
            return move(piece, firstTile, newTile);
        }

        public boolean containsPlayerPiece(Tile tile) {
            return tile.getPiece().getPlayer().equals(this);
        }

        public Turn moveFromTile(Tile oldTile, int count) {
            Piece piece = oldTile.getPiece();
            if (!hasNthTile(oldTile, count)) {
                return new Turn(false, false);
            }
            Tile newTile = getNthTile(oldTile, count);
            return move(piece, oldTile, newTile);
        }

        private Turn move(Piece piece, Tile oldTile, Tile newTile) {
            Turn turn;
            if (newTile == null) {
                addFinishedPiece(piece);
                turn = new Turn(true, false);
            } else {
                turn = newTile.onEnter(piece);
            }
            if (turn.isSuccessfull()) {
                oldTile.setPiece(null);
            }
            return turn;
        }

        public boolean canMove(Board board, int count) {
            boolean canMove = false;
            for (Map.Entry<String, Tile> tileEntry : board.getTiles().entrySet()) {
                if (!tileEntry.getKey().startsWith("p" + (this == PLAYER1.getPlayer() ? "1" : "2"))) {
                    continue;
                }
                if (!hasNthTile(tileEntry.getValue(), count)) {
                    continue;
                }
                if (getNthTile(tileEntry.getValue(), count).canEnter(tileEntry.getValue().getPiece())) {
                    canMove = true;
                }
            }
            if (!canMove && unusedPieces.size() > 0) {
                canMove = getNthTile(firstTile, count - 1).canEnter(unusedPieces.get(0));
            }
            return canMove;
        }

        public void returnPiece(Piece piece) {
            unusedPieces.push(piece);
        }

        public void addFinishedPiece(Piece piece) {
            finishedPieces.add(piece);
        }


    }


}

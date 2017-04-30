package com.github.cc007.royalgameofur.model.tiles;

import com.github.cc007.royalgameofur.model.Piece;
import com.github.cc007.royalgameofur.model.Players;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rik on 29-4-2017.
 */
public abstract class Tile {
    private Piece piece = null;
    private Map<Players.Player, Tile> next;

    public Tile() {
        next = new HashMap<>();
    }

    public abstract Image getTileImage();

    public abstract Turn onEnter(Piece piece, Tile previousTile);

    public Tile getNext(Players.Player player) {
        return next.get(player);
    }

    public void setNext(Players.Player player, Tile tile) {
        next.put(player, tile);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    protected boolean hasPiece() {
        return piece != null;
    }
}

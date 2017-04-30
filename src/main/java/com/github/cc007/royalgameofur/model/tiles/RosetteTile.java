package com.github.cc007.royalgameofur.model.tiles;

import com.github.cc007.royalgameofur.model.Piece;

import java.awt.*;

/**
 * Created by Rik on 29-4-2017.
 */
public class RosetteTile extends Tile {

    @Override
    public Image getTileImage() {
        return null;
    }

    @Override
    public Turn onEnter(Piece piece, Tile previousTile) {
        if (hasPiece()) {
            return new Turn(false, false);
        }
        previousTile.setPiece(null);
        setPiece(piece);
        return new Turn(true, true);
    }
}

package com.github.cc007.royalgameofur.model.tiles;

import com.github.cc007.royalgameofur.model.Piece;
import com.github.cc007.royalgameofur.model.Turn;

import java.awt.*;

/**
 * Created by Rik on 29-4-2017.
 */
public class NormalTile extends Tile {
    @Override
    public Image getTileImage() {
        return null;
    }

    @Override
    public Turn onEnter(Piece piece) {
        if (hasPiece()) {
            if (getPiece().getPlayer() == piece.getPlayer()) {
                return new Turn(false, false);
            } else {
                getPiece().getPlayer().returnPiece(getPiece());
            }
        }
        setPiece(piece);
        return new Turn(true, false);
    }

    @Override
    public boolean canEnter(Piece piece) {
        if (hasPiece() && getPiece().getPlayer() == piece.getPlayer()) {
            return false;
        }
        return true;
    }
}

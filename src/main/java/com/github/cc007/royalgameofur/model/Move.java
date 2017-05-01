package com.github.cc007.royalgameofur.model;

import com.github.cc007.royalgameofur.model.tiles.Tile;

/**
 * Created by Rik on 1-5-2017.
 */
public class Move {
    private boolean newPiece;
    private Tile moveFromTile;

    public static Move newPieceMove(){
        return new Move(true, null);
    }

    public static Move newTileMove(Tile tile){
        return new Move(false, tile);
    }
    private Move(boolean newPiece, Tile moveFromTile) {
        this.newPiece = newPiece;
        this.moveFromTile = moveFromTile;
    }

    public boolean isNewPiece() {
        return newPiece;
    }

    public Tile getMoveFromTile() {
        return moveFromTile;
    }
}

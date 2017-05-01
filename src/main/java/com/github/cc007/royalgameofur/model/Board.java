package com.github.cc007.royalgameofur.model;

import com.github.cc007.royalgameofur.model.tiles.NormalTile;
import com.github.cc007.royalgameofur.model.tiles.RosetteTile;
import com.github.cc007.royalgameofur.model.tiles.Tile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rik on 29-4-2017.
 */
public class Board {
    private Map<String, Tile> tiles;

    public Board() {
        tiles = new HashMap<>();
        createTiles();
    }

    private void createTiles() {
        //1st tile
        Tile tileP1 = new NormalTile();
        Tile tileP2 = new NormalTile();

        tiles.put("P1Pos1", tileP1);
        tiles.put("P2Pos1", tileP2);

        Tile previousTileP1 = tileP1;
        Tile previousTileP2 = tileP2;

        //2nd and 3rd tile
        for (int i = 2; i <= 3; i++) {
            tileP1 = new NormalTile();
            tileP2 = new NormalTile();

            previousTileP1.setNext(Players.PLAYER1.getPlayer(), tileP1);
            previousTileP1.setNext(Players.PLAYER2.getPlayer(), null);

            previousTileP2.setNext(Players.PLAYER1.getPlayer(), null);
            previousTileP2.setNext(Players.PLAYER2.getPlayer(), tileP2);


            tiles.put("P1Pos" + i, tileP1);
            tiles.put("P2Pos" + i, tileP2);

            previousTileP2 = tileP2;
            previousTileP1 = tileP1;
        }

        //4th tile
        tileP1 = new RosetteTile();
        tileP2 = new RosetteTile();

        previousTileP1.setNext(Players.PLAYER1.getPlayer(), tileP1);
        previousTileP1.setNext(Players.PLAYER2.getPlayer(), null);

        previousTileP2.setNext(Players.PLAYER1.getPlayer(), null);
        previousTileP2.setNext(Players.PLAYER2.getPlayer(), tileP2);

        tiles.put("P1Pos4", tileP1);
        tiles.put("P2Pos4", tileP2);

        previousTileP1 = tileP1;
        previousTileP2 = tileP2;

        //5th tile
        Tile tile = new NormalTile();

        previousTileP1.setNext(Players.PLAYER1.getPlayer(), tile);
        previousTileP1.setNext(Players.PLAYER2.getPlayer(), null);

        previousTileP2.setNext(Players.PLAYER1.getPlayer(), null);
        previousTileP2.setNext(Players.PLAYER2.getPlayer(), tile);

        tiles.put("P1Pos6", tile);
        tiles.put("P2Pos6", tile);

        Tile previousTile = tile;

        //6th and 7th tile
        for (int i = 6; i <= 7; i++) {
            tile = new NormalTile();

            previousTile.setNext(Players.PLAYER1.getPlayer(), tile);
            previousTile.setNext(Players.PLAYER2.getPlayer(), tile);


            tiles.put("P1Pos" + i, tile);
            tiles.put("P2Pos" + i, tile);

            previousTile = tile;
        }

        //8th tile
        tile = new RosetteTile();

        previousTile.setNext(Players.PLAYER1.getPlayer(), tile);
        previousTile.setNext(Players.PLAYER2.getPlayer(), tile);

        tiles.put("P1Pos8", tile);
        tiles.put("P2Pos8", tile);

        previousTile = tile;

        //9th to 12th tile
        for (int i = 9; i <= 12; i++) {
            tile = new NormalTile();

            previousTile.setNext(Players.PLAYER1.getPlayer(), tile);
            previousTile.setNext(Players.PLAYER2.getPlayer(), tile);


            tiles.put("P1Pos" + i, tile);
            tiles.put("P2Pos" + i, tile);

            previousTile = tile;
        }

        //13th tile
        tileP1 = new NormalTile();
        tileP2 = new NormalTile();

        previousTile.setNext(Players.PLAYER1.getPlayer(), tileP1);
        previousTile.setNext(Players.PLAYER2.getPlayer(), tileP2);

        tiles.put("P1Pos13", tileP1);
        tiles.put("P2Pos13", tileP2);

        previousTileP1 = tileP1;
        previousTileP2 = tileP2;

        //14th tile
        tileP1 = new NormalTile();
        tileP2 = new NormalTile();

        previousTileP1.setNext(Players.PLAYER1.getPlayer(), tileP1);
        previousTileP1.setNext(Players.PLAYER2.getPlayer(), null);

        previousTileP2.setNext(Players.PLAYER1.getPlayer(), null);
        previousTileP2.setNext(Players.PLAYER2.getPlayer(), tileP2);

        tiles.put("P1Pos14", tileP1);
        tiles.put("P2Pos14", tileP2);
    }

    public Map<String, Tile> getTiles() {
        return tiles;
    }
}

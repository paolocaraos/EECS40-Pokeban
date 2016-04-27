package com.example.paolo.pokeban;

import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class FloorTile {

    GameObject object;

    int sideLength;

    boolean targetTile;

    int x;
    int y;

    Rect tileSpace;

    GameObject getGameObject(){
        return object;
    }
}

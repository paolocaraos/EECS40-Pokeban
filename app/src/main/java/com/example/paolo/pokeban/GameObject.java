package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public abstract class GameObject{
    FloorTile tile;

    boolean moveableUP;
    boolean moveableDOWN;
    boolean moveableLEFT;
    boolean moveableRIGHT;

    int tileX;
    int tileY;

    Rect objectSpace;
    Bitmap icon;

    boolean isActive;

    abstract void draw(Canvas canvas, int x, int y, int sideLength);

    abstract PlayerView.Direction move(PlayerView.Direction direction);

    abstract FloorTile getTile();

    abstract void deactivate();

    abstract boolean verifyActive();

    abstract void setTile(FloorTile floorTile, int x, int y);

    abstract void detachFromTile();

    abstract int getTileX();

    abstract int getTileY();

    abstract void updateMobility(FloorTile[][] floor);

    abstract boolean checkMobility(PlayerView.Direction direction);
}

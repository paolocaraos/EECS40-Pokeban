package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public abstract class GameObject{

    int tile_X;
    int tile_Y;

    FloorTile tile;

    Rect objectSpace;
    Bitmap icon;

    abstract void draw(Canvas canvas, int x, int y, int sideLength);

    abstract PlayerView.Direction move(PlayerView.Direction direction);

    abstract FloorTile getTile();

    abstract void setTile(FloorTile floorTile);

    abstract void setArrayCoordinates(int x, int y);
}

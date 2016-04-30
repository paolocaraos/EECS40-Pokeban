package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class Wall extends GameObject{

    Wall(Bitmap wallIcon){
        objectSpace = new Rect();
        this.icon = wallIcon;
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y+ sideLength/2);
        canvas.drawBitmap(icon, null, objectSpace, null);
    }

    void setArrayCoordinates(int x, int y){
        tile_X = x;
        tile_Y = y;
    }

    PlayerView.Direction move(PlayerView.Direction direction){
        return PlayerView.Direction.STAY;
    }

    FloorTile getTile(){
        return tile;
    }

    void setTile(FloorTile floorTile){
        tile = floorTile;
    }
}
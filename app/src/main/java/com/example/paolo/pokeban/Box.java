package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class Box extends GameObject{

    boolean isActive;

    Box(Bitmap boxIcon){
        objectSpace = new Rect();
        this.icon = boxIcon;
        isActive = false;
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y + sideLength/2);
        canvas.drawBitmap(icon,null,objectSpace,null);
    }

    void setArrayCoordinates(int x, int y){
        tile_X = x;
        tile_Y = y;

        isActive = true;
    }

    PlayerView.Direction move(PlayerView.Direction direction){
        return PlayerView.Direction.STAY;
    }

    boolean checkAdjacent(){
        return false;
    }

    boolean checkTarget(){
        return false;
    }

    boolean verifyActive(){ return isActive;}

    int getTile_X_coordinate(){
        return tile_X;
    }

    int getTile_Y_coordinate(){
        return tile_Y;
    }

    FloorTile getTile(){
        return tile;
    }

    void setTile(FloorTile floorTile){
        tile = floorTile;
    }
}

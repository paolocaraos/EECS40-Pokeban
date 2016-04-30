package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class Box extends GameObject{

    Box(Bitmap boxIcon){
        objectSpace = new Rect();
        this.icon = boxIcon;
        isActive = false;
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y + sideLength/2);
        canvas.drawBitmap(icon,null,objectSpace,null);
    }

    PlayerView.Direction move(PlayerView.Direction direction){
        return PlayerView.Direction.STAY;
    }


    boolean verifyActive(){ return isActive;}

    void deactivate(){
        isActive = false;

        tile.removeGameObject();

        tile = null;
    }

    FloorTile getTile(){
        return tile;
    }

    void setTile(FloorTile floorTile){
        tile = floorTile;
        isActive = true;
    }
}

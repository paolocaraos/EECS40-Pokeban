package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class Player extends GameObject{

    Player(Bitmap icon){
        objectSpace = new Rect();
        this.icon = icon;
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y+ sideLength/2);
        canvas.drawBitmap(icon, null, objectSpace, null);
    }

    FloorTile getTile(){
        return tile;
    }

    void setTile(FloorTile floorTile) {
        tile = floorTile;
    }

    boolean verifyActive(){
        return isActive;
    }

    void deactivate(){
        isActive = false;

        tile.removeGameObject();

        tile = null;
    }

    PlayerView.Direction move(PlayerView.Direction direction){
        return direction;
    }
}
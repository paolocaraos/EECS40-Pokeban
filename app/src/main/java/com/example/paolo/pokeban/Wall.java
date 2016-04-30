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

        moveableUP = false;
        moveableDOWN = false;
        moveableLEFT = false;
        moveableRIGHT = false;
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y+ sideLength/2);
        canvas.drawBitmap(icon, null, objectSpace, null);
    }


    PlayerView.Direction move(PlayerView.Direction direction){
        return PlayerView.Direction.STAY;
    }

    FloorTile getTile(){
        return tile;
    }

    void setTile(FloorTile floorTile, int x, int y){
        isActive = true;
        tile = floorTile;

        tileX = x;
        tileY = y;
    }

    int getTileX(){
        return tileX;
    }

    int getTileY(){
        return tileY;
    }

    boolean verifyActive(){
        return isActive;
    }

    void deactivate(){
        isActive = false;
        tileX = 0;
        tileY = 0;

        tile.removeGameObject();

        tile = null;
    }

    void updateMobility(FloorTile[][] floor){

    }

    boolean checkMobility(PlayerView.Direction direction){

        if(direction == PlayerView.Direction.UP){
            return moveableUP;
        }else if(direction == PlayerView.Direction.DOWN){
            return moveableDOWN;
        } else if(direction == PlayerView.Direction.LEFT){
            return moveableLEFT;
        }else if(direction == PlayerView.Direction.RIGHT){
            return moveableRIGHT;
        }

        return false;
    }

    void detachFromTile(){
        tile = null;

        tileX = 0;
        tileY = 0;
    }
}
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
        tileX = 0;
        tileY = 0;

        tile.removeGameObject();

        tile = null;
    }

    FloorTile getTile(){
        return tile;
    }

    int getTileX(){
        return tileX;
    }

    int getTileY(){
        return tileY;
    }

    void setTile(FloorTile floorTile, int x, int y){
        tile = floorTile;
        isActive = true;

        tileY = y;
        tileX = x;
    }

    void updateMobility(FloorTile[][] floor){
        GameObject objectAbove = floor[tileX][tileY + 1].getGameObject();
        GameObject objectBelow = floor[tileX][tileY - 1].getGameObject();
        GameObject objectRight = floor[tileX + 1][tileY].getGameObject();
        GameObject objectLeft = floor[tileX + 1][tileY].getGameObject();


        if(objectLeft == null){
            moveableLEFT = true;
        }else{
            moveableLEFT = false;
        }


        if(objectRight == null){
            moveableRIGHT = true;
        }else{
            moveableRIGHT = false;
        }

        if(objectBelow == null){
            moveableDOWN = true;
        }else{
            moveableDOWN = false;
        }

        if(objectAbove == null){
            moveableUP = true;
        }else{
            moveableUP = false;
        }
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

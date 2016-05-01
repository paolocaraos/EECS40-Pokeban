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

    void setTile(FloorTile floorTile, int x, int y) {
        tile = floorTile;

        tileX = x;
        tileY = y;
    }

    boolean verifyActive(){
        return isActive;
    }

    void deactivate(){
        isActive = false;

        tile.removeGameObject();

        tile = null;
    }

    PlayerView.Direction move(PlayerView.Direction direction, FloorTile[][] floorTiles){
        tile.nullObjectPointer();
        switch (direction){
            case UP:
                floorTiles[tileX][tileY-1].setGameObject(this,tileX,tileY-1);
            case DOWN:
                floorTiles[tileX][tileY+1].setGameObject(this,tileX,tileY+1);
                break;
            case LEFT:
                floorTiles[tileX-1][tileY].setGameObject(this,tileX-1,tileY);
                break;
            case RIGHT:
                floorTiles[tileX+1][tileY].setGameObject(this,tileX+1,tileY);
                break;
            default:
                break;
        }
        return direction;
    }

    int getTileX(){
        return tileX;
    }

    int getTileY(){
        return tileY;
    }

    void updateMobility(FloorTile[][] floor){
        GameObject objectAbove = floor[tileX][tileY + 1].getGameObject();
        GameObject objectBelow = floor[tileX][tileY - 1].getGameObject();
        GameObject objectRight = floor[tileX + 1][tileY].getGameObject();
        GameObject objectLeft = floor[tileX + 1][tileY].getGameObject();


        if(objectLeft == null | objectLeft.moveableLEFT){
            moveableLEFT = true;
        }else{
            moveableLEFT = false;
        }


        if(objectRight == null | objectRight.moveableRIGHT){
            moveableRIGHT = true;
        }else{
            moveableRIGHT = false;
        }

        if(objectBelow == null | objectBelow.moveableDOWN){
            moveableDOWN = true;
        }else{
            moveableDOWN = false;
        }

        if(objectAbove == null | objectAbove.moveableUP){
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
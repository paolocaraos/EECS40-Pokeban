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

    PlayerView.Direction move(PlayerView.Direction direction, FloorTile[][] floorTiles){
        tile.nullObjectPointer();
        switch (direction){
            case UP:
                floorTiles[tileX][tileY-1].setGameObject(this);
                break;
            case DOWN:
                floorTiles[tileX][tileY+1].setGameObject(this);
                break;
            case LEFT:
                floorTiles[tileX-1][tileY].setGameObject(this);
                break;
            case RIGHT:
                floorTiles[tileX+1][tileY].setGameObject(this);
                break;
            default:
                break;
        }
        return direction;
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
        GameObject objectAbove = floor[tileX][tileY - 1].getGameObject();
        GameObject objectBelow = floor[tileX][tileY + 1].getGameObject();
        GameObject objectRight = floor[tileX + 1][tileY].getGameObject();
        GameObject objectLeft = floor[tileX - 1][tileY].getGameObject();

        moveableLEFT = objectLeft == null;

        moveableRIGHT = objectRight == null;

        moveableDOWN = objectBelow == null;

        moveableUP = objectAbove == null;
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

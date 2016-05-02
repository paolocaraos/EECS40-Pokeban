package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Paolo on 4/27/2016.
 */
public class Level {

    private int currentLevel;
    boolean initiateNextLevel;

    FloorTile[][] floor;
    Wall[] wall;
    Box[] box;
    Bitmap[] targetIcon;
    Player player;

    Level(FloorTile[][] floorTiles, Wall[] walls, Box[] boxes, Bitmap[] targetIcon, Player player){
        floor = floorTiles;
        wall = walls;
        box = boxes;
        this.targetIcon = targetIcon;
        this.player = player;

        initiateNextLevel = true;
        currentLevel = 0;
    }

    void draw(Canvas canvas){
        for (FloorTile[] aFloor : floor) {
            for (int j = 0; j < aFloor.length; j++) {
                aFloor[j].draw(canvas);
            }
        }
    }

    void initiate() {
        int wallCounter = 0;
        int boxCounter = 0;
        int iconCounter = 0;

        floor[3][5].setGameObject(player, 3, 5);

        switch (currentLevel) {
            case 0:
                for (int i = 0; i < floor.length; i++) {
                    for (int j = 0; j < floor[i].length; j++) {

                        if (i == 0 | i == floor.length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++], i , j);
                        } else if (j == 0 | j == floor[i].length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++], i , j);
                        }

                        if ((i == 1 & j == 1) | (i == floor.length - 2 & j == 1) |
                                (i == 1 & j == floor[i].length - 2) | (i == floor.length - 2 & j == floor[i].length - 2)) {
                            floor[i][j].setIcon(targetIcon[iconCounter++]);
                        }

                        if ((i == 4 & j == 4) | (i == floor.length - 5 & j == 4) |
                                (i == 4 & j == floor[i].length - 5) | (i == floor.length - 5 & j == floor[i].length - 4)) {
                            floor[i][j].setGameObject(box[boxCounter++], i, j);
                        }
                    }

                }
                break;
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            default:
                break;
        }
    }

    void update(){

        if(initiateNextLevel){
            initiate();
            initiateNextLevel = false;
        }

        for(int i = 0; box[i].verifyActive(); i++){
            box[i].updateMobility(floor);
        }

        player.updateMobility(floor);

        if(complete()){
            initiateNextLevel = true;
            currentLevel++;
            deactivateLevel();

            //CLick to resume next level
        }
    }

    boolean complete() {
        boolean boxOnTarget = true;

        for (int i = 0; box[i].verifyActive(); i++) {
            boxOnTarget = boxOnTarget & box[i].getTile().verifyTargetTile();
        }

        return boxOnTarget;
    }

    void deactivateLevel(){
        for(int i = 0; box[i].verifyActive(); i++)
            box[i].deactivate();

        player.deactivate();
    }

    boolean movePlayer(PlayerView.Direction direction){
        GameObject destObject;

        if(player.checkMobility(direction)){
            int tilex = player.getTileX();
            int tiley = player.getTileY();

            switch(direction){
                case UP:
                    destObject = floor[tilex][tiley-1].getGameObject();
                    break;
                case DOWN:
                    destObject = floor[tilex][tiley+1].getGameObject();
                    break;
                case LEFT:
                    destObject = floor[tilex-1][tiley].getGameObject();
                    break;
                case RIGHT:
                    destObject = floor[tilex+1][tiley].getGameObject();
                    break;
                default:
                    destObject = null;
                    break;
            }
            /*actually moving the player/object*/
            if(destObject!=null){
                if(destObject.checkMobility(direction)){
                            /*box moves*/
                    destObject.move(direction,floor);
                            /*make player move*/
                    player.move(direction,floor);
                }
            }
            else{
                        /*make player move*/
                player.move(direction,floor);
            }
        }
        return false;
    }
}


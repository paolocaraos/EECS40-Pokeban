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



        switch (currentLevel) {
            case 0:
                floor[3][6].setGameObject(box[boxCounter++]);
                floor[3][7].setIcon(targetIcon[iconCounter++]);
                floor[3][5].setGameObject(player);
                for (int i = 0; i < floor.length; i++) {
                    for (int j = 0; j < floor[i].length; j++) {

                        if (i == 0 | i == floor.length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (j == 0 | j == floor[i].length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        }
                    }

                }
                break;
            case 1:
                floor[4][1].setGameObject(player);
                for(int i =0; i <floor.length; i++){
                    for (int j = 0; j< floor[i].length-3; j++){
                        /* walls */
                        if (i == 0 | i == floor.length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (j == 0 | j == floor[i].length - 4) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (i == 2 & j == 1){
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (i == 3 & j == 5){
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (i == 4 & j == 2) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        }
                        /* targets */
                        if ((i == 5 & j == 1) | (i == 3 & j == 4) |
                                (i == 4 & j == 4)) {
                            floor[i][j].setIcon(targetIcon[iconCounter++]);
                        }
                        /* boxes */
                        if ((i == 2 & j == 2) | (i == 2 & j == 3) |
                                (i == 5 & j == 2)) {
                            floor[i][j].setGameObject(box[boxCounter++]);
                        }

                    }
                }
                break;

            case 2:
                floor[3][3].setGameObject(player);
                for(int i =0; i <floor.length; i++) {
                    for (int j = 0; j < floor[i].length - 1; j++) {
                        /* walls */
                        if (i == 0 | i == floor.length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (j == 0 | j == floor[i].length - 2) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if ((i == 1 & ((j == 3) | (j == 4) | (j == 5)))
                                | (i == 4 & ((j == 1) | (j == 2) | (j == 6) | (j == 7)))
                                | (i == 5 & ((j == 1) | (j == 2) | (j == 6) | (j == 7)))) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        }
                        /* targets */
                        if ((i == 3 & j == 4) | (i == 4 & j == 4) |
                                (i == 5 & j == 4)) {
                            floor[i][j].setIcon(targetIcon[iconCounter++]);
                        }
                        /* boxes */
                        if ((i == 2 & j == 2) | (i == 4 & j == 5) |
                                (i == 2 & j == 6)) {
                            floor[i][j].setGameObject(box[boxCounter++]);
                        }
                    }
                }
                break;

            case 3:
                floor[3][8].setGameObject(player);
                for(int i =0; i <floor.length; i++) {
                    for (int j = 0; j < floor[i].length; j++) {
                        /* walls */
                        if (i == 0 | i == floor.length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if (j == 0 | j == floor[i].length - 1) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        } else if ((i == 1 & ((j == 1) | (j == 2) | (j == 3) | (j==8)))
                                | (i == 2 & ((j == 1) | (j == 5) | (j == 6) | (j == 8)))
                                | (i == 4 & j == 8)
                                | (i == 5 & ((j == 1) | (j == 2) | (j == 3) | (j == 4) | (j==5) | (j==8)))) {
                            floor[i][j].setGameObject(wall[wallCounter++]);
                        }
                        /* targets */
                        if ((i == 2 & j == 2) | (i == 3 & j == 1) |
                                (i == 3 & j == 2) | (i == 4 & j == 1) | (i == 4 & j == 2)) {
                            floor[i][j].setIcon(targetIcon[iconCounter++]);
                        }
                        /* boxes */
                        if ((i == 2 & j == 4) | (i == 3 & j == 3) |
                                (i == 3 & j == 5) | (i == 4 & j == 4) | (i == 4 & j == 6)) {
                            floor[i][j].setGameObject(box[boxCounter++]);
                        }
                    }
                }
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
            currentLevel = currentLevel % 3;
            deactivateLevel();

            System.out.println("Level completed.");
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

        for(int i = 0; i < wall.length; i++)
            wall[i].deactivate();

        player.deactivate();

        for(int i = 0; i < floor.length; i ++){
            for( int j = 0; j < floor[i].length; j++ ){
                floor[i][j].deactivate();
            }
        }
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


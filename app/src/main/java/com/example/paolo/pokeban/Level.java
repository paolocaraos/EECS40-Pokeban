package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Paolo on 4/27/2016.
 */
public class Level {

    private int currentLevel;

    FloorTile[][] floor;
    Wall[] wall;
    Box[] box;
    Bitmap[] targetIcon;

    Level(FloorTile[][] floorTiles, Wall[] walls, Box[] boxes, Bitmap[] targetIcon){
        floor = floorTiles;
        wall = walls;
        box = boxes;
        this.targetIcon = targetIcon;
    }

    void draw(Canvas canvas){
        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j].draw(canvas);
            }
        }
    }

    void initiate(){
        int wallCounter = 0;
        int iconCounter = 0;

        for(int i = 0; i < floor.length; i++){
            for (int j = 0; j < floor[i].length; j++){

                if(i == 0 | i == floor.length - 1) {
                    floor[i][j].setGameObject(wall[wallCounter++]);
                }
                else if(j == 0 | j == floor[i].length - 1){
                    if(floor[i][j].getGameObject() == null){
                        floor[i][j].setGameObject(wall[wallCounter++]);
                    }
                }

                if((i == 1 & j == 1) | (i == floor.length -2 & j == 1) |
                        (i == 1 & j == floor[i].length - 2) | (i == floor. length - 2 & j == floor[i].length - 2)){
                    floor[i][j].setIcon(targetIcon[iconCounter++]);
                }
            }
        }

    }
}


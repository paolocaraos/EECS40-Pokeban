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
    Player player;

    Level(FloorTile[][] floorTiles, Wall[] walls, Box[] boxes, Bitmap[] targetIcon, Player player){
        floor = floorTiles;
        wall = walls;
        box = boxes;
        this.targetIcon = targetIcon;
        this.player = player;
    }

    void draw(Canvas canvas){
        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j].draw(canvas);
            }
        }
    }

    void initiate() {
        int wallCounter = 0;
        int boxCounter = 0;
        int iconCounter = 0;

        floor[3][5].setGameObject(player);

        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {

                if (i == 0 | i == floor.length - 1) {
                    floor[i][j].setGameObject(wall[wallCounter++]);
                } else if (j == 0 | j == floor[i].length - 1) {
                    floor[i][j].setGameObject(wall[wallCounter++]);
                }

                if ((i == 1 & j == 1) | (i == floor.length - 2 & j == 1) |
                        (i == 1 & j == floor[i].length - 2) | (i == floor.length - 2 & j == floor[i].length - 2)) {
                    floor[i][j].setIcon(targetIcon[iconCounter++]);
                }

                if((i == 4 & j == 4) | (i == floor.length -5 & j == 4) |
                        (i == 4 & j == floor[i].length - 5) | (i == floor. length - 5 & j == floor[i].length - 4)){
                    floor[i][j].setGameObject(box[boxCounter++]);
                }
            }
        }
    }

    void update(){

    }
}


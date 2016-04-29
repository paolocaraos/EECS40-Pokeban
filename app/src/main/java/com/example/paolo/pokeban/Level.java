package com.example.paolo.pokeban;

import android.graphics.Canvas;

/**
 * Created by Paolo on 4/27/2016.
 */
public class Level {

    FloorTile[][] floor;
    Wall[] wall;
    Box[] box;

    Level(FloorTile[][] floorTiles, Wall[] walls, Box[] boxes){
        floor = floorTiles;
        wall = walls;
        box = boxes;
    }

    void draw(Canvas canvas){
        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j].draw(canvas);
            }
        }
    }

    void initiateLevel_1(){


    }
}


package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class FloorTile {

    GameObject object;

    final int sideLength = 60;

    boolean targetTile;

    int x;
    int y;

    int screenX;
    int screenY;

    Rect tileSpace;

    Bitmap icon;
    Paint paint;

    FloorTile(int screen_x, int screen_y){
        screenX = screen_x;
        screenY = screen_y;

        tileSpace = new Rect();
    }

    void draw(Canvas canvas, int x, int y){
        paint = new Paint();
        paint.setColor(Color.BLACK);


    }

    GameObject getGameObject(){
        return object;
    }
}

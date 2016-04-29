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

    static int screenX;
    static int screenY;

    Rect tileSpace;

    Bitmap icon;
    Paint paint;

    FloorTile(Bitmap tileIcon, int screen_x, int screen_y, int x_offset, int y_offset){
        this.icon = tileIcon;

        x = x_offset;
        y = y_offset;

        screenX = screen_x;
        screenY = screen_y;

        tileSpace = new Rect();
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    void draw(Canvas canvas){

    }

    GameObject getGameObject(){

        return object;
    }
}

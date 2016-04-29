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
    boolean targetTile;

    final int sideLength = 60;

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
        tileSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y+ sideLength/2);
        canvas.drawRect(tileSpace, paint);
        object.draw(canvas, x, y, sideLength);
    }

    GameObject getGameObject(){

        return object;
    }
}

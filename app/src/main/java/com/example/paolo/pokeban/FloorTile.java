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

    final int sideLength = 100;

    int x;
    int y;

    static int screenX;
    static int screenY;

    Rect tileSpace;

    Bitmap icon;
    Paint paint;

    FloorTile(int screen_x, int screen_y, int x_offset, int y_offset){

        x = screen_x/2 - sideLength*3 + sideLength*x_offset;
        y = sideLength/2 + y_offset*sideLength;

        screenX = screen_x;
        screenY = screen_y;

        tileSpace = new Rect();
        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    void draw(Canvas canvas){

        tileSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y+ sideLength/2);
        canvas.drawRect(tileSpace, paint);
        if(object != null)
            object.draw(canvas, x, y, sideLength);
        if(targetTile)
            canvas.drawBitmap(icon, null, tileSpace, null);
    }

    GameObject getGameObject(){
        return object;
    }

    void setGameObject(GameObject object){
        this.object = object;
    }

    void setIcon(Bitmap icon){
        this.targetTile = true;
        this.icon = icon;
    }
}

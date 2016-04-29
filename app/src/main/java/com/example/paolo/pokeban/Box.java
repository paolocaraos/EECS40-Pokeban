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
    }

    void draw(Canvas canvas, int x, int y, int sideLength){
        objectSpace.set(x - sideLength/2, y - sideLength/2, x + sideLength/2, y + sideLength/2);
        canvas.drawBitmap(icon,null,objectSpace,null);
    }

    boolean move(){
        return false;
    }

    boolean checkAdjacent(){
        return false;
    }

    boolean checkTarget(){
        return false;
    }


}

package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public abstract class GameObject{

    public enum DIRECTION{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    int sideLength;

    int x;
    int y;

    Rect objectSpace;
    Bitmap icon;

    abstract void draw(Canvas canvas, int x, int y, int sideLength);
    abstract boolean move();
}

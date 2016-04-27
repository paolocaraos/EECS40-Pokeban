package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public abstract class GameObject{

    public final int UP = 0;
    public final int DOWN = 1;
    public final int LEFT = 2;
    public final int RIGHT = 3;

    int sideLength;

    int x;
    int y;

    Rect objectSpace;
    Bitmap icon;

    abstract boolean move();
}

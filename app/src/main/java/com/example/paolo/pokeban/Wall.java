package com.example.paolo.pokeban;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by Paolo on 4/21/2016.
 */
public class Wall extends GameObject{

    Wall(Bitmap wallIcon){
        objectSpace = new Rect();
        this.icon = wallIcon;
    }

    boolean move(){
        return false;
    }
}
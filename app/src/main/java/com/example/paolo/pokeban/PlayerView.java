package com.example.paolo.pokeban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Paolo on 4/21/2016.
 */
public class PlayerView extends SurfaceView implements SurfaceHolder.Callback{

    private GameThread gt;

    public final int UP = 0;
    public final int DOWN = 1;
    public final int LEFT = 2;
    public final int RIGHT = 3;

    private int screen_width;
    private int screen_height;

    private Player player;
    private Bitmap playerIcon;

    private Bitmap[] wallIcon = new Bitmap[50];

    private FloorTile[][] floor = new FloorTile[7][10];

    Canvas canvas;
    private Bitmap canvasBG;

    public PlayerView(Context context){
        super(context);

        getHolder().addCallback(this);
        setFocusable(true);


        canvas = new Canvas();
    }

    public void draw(Canvas canvas){

    }

    public void update(Canvas canvas){

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height){
        // Respond to surface changes
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        gt = new GameThread(this);
        gt.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        gt.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        return false;
    }

}
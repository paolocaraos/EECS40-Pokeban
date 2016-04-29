package com.example.paolo.pokeban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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

    private Wall[] wall = new Wall[50];
    private Bitmap[] wallIcon = new Bitmap[50];

    private Box[] box = new Box[10];
    private Bitmap[] boxIcon = new Bitmap[10];

    private FloorTile[][] floor = new FloorTile[7][10];
    private Bitmap[][] tileIcons = new Bitmap[7][10];

    private Level level;
    private int currentLevel = 0;

    Canvas canvas;
    private Bitmap canvasBG;


    public PlayerView(Context context){
        super(context);

        getHolder().addCallback(this);
        setFocusable(true);

        canvas = new Canvas();
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);

        level.draw(canvas);
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

        this.screen_width = getWidth();
        this.screen_height = getHeight();

        for(int i = 0; i < wall.length; i++){
            wallIcon[i] = BitmapFactory.decodeResource(getResources(), R.mipmap._poketree);
            wall[i] = new Wall(wallIcon[i]);
        }

        for(int i = 0; i < box.length; i++){
            boxIcon[i] = BitmapFactory.decodeResource(getResources(), R.mipmap._pokeball);
            box[i] = new Box(boxIcon[i]);
        }

        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j] = new FloorTile(tileIcons[i][j], screen_width, screen_height, i , j);
            }
        }

        playerIcon = BitmapFactory.decodeResource(getResources(), R.mipmap._trainer);
        player = new Player();

        level = new Level(floor, wall, box);
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
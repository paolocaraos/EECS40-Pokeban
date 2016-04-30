package com.example.paolo.pokeban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Paolo on 4/21/2016.
 */
public class PlayerView extends SurfaceView implements SurfaceHolder.Callback{

    private GameThread gt;

    public enum Direction{
        STAY,
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private int screen_width;
    private int screen_height;

    private Player player;
    private Bitmap playerIcon;

    private Wall[] wall = new Wall[50];
    private Bitmap[] wallIcon = new Bitmap[50];

    private Box[] box = new Box[10];
    private Bitmap[] boxIcon = new Bitmap[10];

    private FloorTile[][] floor = new FloorTile[7][10];
    private Bitmap[] targetIcon = new Bitmap[10];

    private Bitmap cursor;
    private Rect cursorSpace;

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

        cursorSpace.set(screen_width / 2 - 360, screen_height - 500, screen_width / 2 + 360, screen_height - 100);
        canvas.drawBitmap(cursor, null, cursorSpace, null);


        //Update game state
        level.update();
    }

    public void update(Canvas canvas){
        level.update();
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

        cursorSpace = new Rect();
        cursor = BitmapFactory.decodeResource(getResources(), R.mipmap._arrowkeys);

        for(int i = 0; i < wall.length; i++){
            wallIcon[i] = BitmapFactory.decodeResource(getResources(), R.mipmap._poketree);
            wall[i] = new Wall(wallIcon[i]);
        }

        for(int i = 0; i < box.length; i++){
            boxIcon[i] = BitmapFactory.decodeResource(getResources(), R.mipmap._pokeball);
            box[i] = new Box(boxIcon[i]);
        }

        for(int i = 0; i < targetIcon.length; i++){
            targetIcon[i] = BitmapFactory.decodeResource(getResources(), R.mipmap._charizard);
        }

        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[i].length; j++){
                floor[i][j] = new FloorTile(screen_width, screen_height, i , j);
            }
        }

        playerIcon = BitmapFactory.decodeResource(getResources(), R.mipmap._trainer);
        player = new Player(playerIcon);


        level = new Level(floor, wall, box, targetIcon, player);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        gt.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        float touchX = e.getX();
        float touchY = e.getY();

        System.out.println("touch x = " + touchX);

        if(touchX < screen_width/2 + 120 & touchX > screen_width/2 - 120 &
                touchY > screen_height - 500 & touchY < screen_height - 300){
            //player goes up
            Log.d("Log.DEBUG", "Command Up");
            player.move(Direction.UP);
        }else if(touchX < screen_width/2 - 120 & touchX > screen_width/2 - 360 &
                touchY > screen_height - 300 & touchY < screen_height - 100){
            //player goes left
            Log.d("Log.DEBUG", "Command Left");
            player.move(Direction.LEFT);
        }else if(touchX < screen_width/2 + 120 & touchX > screen_width/2 - 120 &
                touchY > screen_height - 300 & touchY < screen_height - 100) {
            //player goes down
            Log.d("Log.DEBUG", "Command Down");
            player.move(Direction.DOWN);
        }else if(touchX < screen_width/2 + 360 & touchX > screen_width/2 + 120 &
                touchY > screen_height - 300 & touchY < screen_height - 100) {
            //player goes right
            Log.d("Log.DEBUG", "Command Right");
            player.move(Direction.RIGHT);
        }

        return true;
    }

}
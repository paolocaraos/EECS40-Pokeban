package com.example.paolo.pokeban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.paolo.pokeban.PlayerView;

public class MainActivity extends AppCompatActivity {
    PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerView = new PlayerView(this);

        setContentView(playerView);
    }
}
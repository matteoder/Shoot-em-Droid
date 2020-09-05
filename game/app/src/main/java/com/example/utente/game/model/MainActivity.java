package com.example.utente.game.model;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.utente.game.*;
public class MainActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.soundtrackstart);
        mediaPlayer.start();
    }
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }
    public void startGame(View V){

        Log.i("ImageButton","clicked");
        Intent intent = new Intent(this,Startgame.class);
        startActivity(intent);
        finish();
    }

    public void setting(View v){
        Intent intent=new Intent(this,Settings.class);
        startActivity(intent);
        finish();
    }
    public void leaderboard(View v){
        Intent intent=new Intent(this,Leaderboard.class);
        startActivity(intent);
        finish();
    }
    public void exit(View view) {
        finish();
    }
    }


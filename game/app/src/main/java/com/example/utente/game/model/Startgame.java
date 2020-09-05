package com.example.utente.game.model;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.example.utente.game.*;
import com.example.utente.game.view.GameView;

public class Startgame extends Activity {

    GameView gameview;
    MediaPlayer mediaPlayer;
    static public int tank=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.soundtrackgame);

        mediaPlayer.start();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        gameview = new GameView(this);
        setContentView(gameview);

    }
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

}

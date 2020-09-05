package com.example.utente.game.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.example.utente.game.*;



public class Settings extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

    public void blackTank(View view) {
        Startgame.tank = 0;
    }

    public void sandTank(View view) {
        Startgame.tank = 1;
    }

    public void blueTank(View view) {
        Startgame.tank = 2;
    }

    public void goback(View view) {
        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
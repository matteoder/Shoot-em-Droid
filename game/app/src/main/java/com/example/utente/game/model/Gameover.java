package com.example.utente.game.model;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.example.utente.game.*;
import java.util.Calendar;
import java.util.Date;

public class Gameover extends Activity {
    TextView tvScore, bestScore, secondScore, thirdScore;
    public static int scoreSP, scoreSP1, scoreSP2;
    public Date data1, data2, data3;
    public static String d1, d2, d3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        scoreSP = pref.getInt("scoreSP", 0);
        scoreSP1 = pref.getInt("scoreSP1", 0);
        scoreSP2 = pref.getInt("scoreSP2", 0);
        d1 = pref.getString("d1", "");
        d2 = pref.getString("d2", "");
        d3 = pref.getString("d3", "");

        SharedPreferences.Editor editor = pref.edit();


        if (score > scoreSP) {
            int temp = scoreSP;
            int temp1 = scoreSP1;
            scoreSP = score;
            scoreSP1 = temp;
            scoreSP2 = temp1;
            String string1 = d1;
            String string2 = d2;
            data1 = Calendar.getInstance().getTime();
            d1 = DateFormat.format("yyyy.MM.dd", data1).toString();
            d2 = string1;
            d3 = string2;
            editor.putInt("scoreSP", scoreSP);
            editor.putInt("scoreSP1", scoreSP1);
            editor.putInt("scoreSP2", scoreSP2);
            editor.putString("d1", d1);
            editor.putString("d2", d2);
            editor.putString("d3", d3);
            editor.commit();
        }
        else if (score > scoreSP1) {
            int temp = scoreSP1;
            scoreSP1 = score;
            scoreSP2 = temp;
            String string1 = d2;
            data2 = Calendar.getInstance().getTime();
            d2 = DateFormat.format("yyyy.MM.dd", data2).toString();
            d3 = string1;
            editor.putInt("scoreSP2", scoreSP2);
            editor.putInt("scoreSP1", scoreSP1);
            editor.putString("d2", d2);
            editor.putString("d3", d3);
            editor.commit();
        }else if (score > scoreSP2) {

            scoreSP2 = score;
            data3 = Calendar.getInstance().getTime();
            editor.putInt("scoreSP2", scoreSP2);
            data3 = Calendar.getInstance().getTime();
            d3 = DateFormat.format("yyyy.MM.dd", data3).toString();
            editor.putString("d3", d3);
            editor.commit();
        }

            tvScore = findViewById(R.id.tvScore);
            bestScore = findViewById(R.id.bestScore);
            secondScore = findViewById(R.id.secondScore);
            thirdScore = findViewById(R.id.thirdScore);

            tvScore.setText("" + score);
            bestScore.setText("*  " + scoreSP);
            secondScore.setText("*  " + scoreSP1);
            thirdScore.setText("*  " + scoreSP2);

        }


    public void restart(View view) {
        Intent intent = new Intent(Gameover.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void exit(View view) {
        finish();
    }
}


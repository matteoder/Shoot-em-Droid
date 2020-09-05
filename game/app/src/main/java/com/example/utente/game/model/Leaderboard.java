package com.example.utente.game.model;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.example.utente.game.*;


public class Leaderboard extends Activity {
    TextView primo,secondo,terzo;
    int best1, best2, best3;
   String d1,d2,d3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        int first = pref.getInt("first",0);
        int second = pref.getInt("second",0);
        int third = pref.getInt("third",0);
        String data1=pref.getString("data1","");
        String data2=pref.getString("data2","");
        String data3=pref.getString("data3","");
        SharedPreferences.Editor editor =pref.edit();
        best1=Gameover.scoreSP;
        best2=Gameover.scoreSP1;
        best3=Gameover.scoreSP2;
        d1=Gameover.d1;
        d2=Gameover.d2;
        d3=Gameover.d3;

     if(best1>first){
         first=best1;
         data1=d1;
         editor.putInt("first",first);
         editor.putString("data1",data1);
         editor.commit();
     }
        if(best2>second){
            second=best2;
            data2=d2;
            editor.putInt("second",second);
            editor.putString("data2",data2);
            editor.commit();
        }
        if(best3>third){
            third=best3;
            data3=d3;
            editor.putInt("third",third);
            editor.putString("data3",data3);
            editor.commit();
        }
        primo=findViewById(R.id.primo);
        secondo=findViewById(R.id.secondo);
        terzo=findViewById(R.id.terzo);

        primo.setText(""+first+"           "+data1);
        secondo.setText(""+second+"        "+data2);
        terzo.setText(""+third+"           "+data3);
    }
    public void goback(View view) {
        Intent intent = new Intent(Leaderboard.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
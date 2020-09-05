package com.example.utente.game.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.utente.game.*;
import com.example.utente.game.model.R;

import java.util.Random;

public class missile {
    float x,y;
    int mVelocity;
    Bitmap missile;
    Random random;
    public missile(Context context){
        missile = BitmapFactory.decodeResource(context.getResources(), R.drawable.missile);
        x =  GameView.dWidth/2 - getmissileWidth()/2;
        y = Cannon.cannonY - getmissileHeight();
        mVelocity = 100;

    }
    public float getmissileWidth(){
        return missile.getWidth();
    }
    public int getmissileHeight(){
        return missile.getHeight();
    }
    public void resetPosition(){

        x=random.nextInt(1000);;
        y=-300+getmissileHeight();
    }
}

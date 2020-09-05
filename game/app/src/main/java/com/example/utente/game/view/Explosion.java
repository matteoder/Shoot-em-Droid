package com.example.utente.game.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.utente.game.*;
import com.example.utente.game.model.R;

public class Explosion {
    Bitmap explosion[]=new Bitmap[19];
    int explosionFrame=0;
    int explosionX,explosionY;
    public Explosion(Context context){
       explosion[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.exp1);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp2);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp3);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp4);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp5);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp6);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp7);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp8);
        explosion[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp9);
        explosion[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp10);
        explosion[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp11);
        explosion[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp12);
        explosion[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp13);
        explosion[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp14);
        explosion[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp15);
        explosion[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp16);
        explosion[16] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp17);
        explosion[17] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp18);
        explosion[18] = BitmapFactory.decodeResource(context.getResources(),R.drawable.exp19);


    }
    public Bitmap getExplosion(int explosionFrame){
        return explosion[explosionFrame];
    }
    public int getExplosionWidth(){
        return explosion[0].getWidth();
    }
    public int getExplosionHeight(){
        return explosion[0].getHeight();
    }
}

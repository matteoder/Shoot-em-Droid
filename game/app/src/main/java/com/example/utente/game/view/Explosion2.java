package com.example.utente.game.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.utente.game.*;
import com.example.utente.game.model.R;

public class Explosion2  {
    Bitmap explosion1[]=new Bitmap[7];
    int explosionFrame=0;
    int explosionX,explosionY;
    public Explosion2(Context context) {

        explosion1[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explos1);
        explosion1[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos2);
        explosion1[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos3);
        explosion1[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos4);
        explosion1[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos5);
        explosion1[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos6);
        explosion1[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explos7);
    }

    public Bitmap getExplosion(int explosionFrame){
        return explosion1[explosionFrame];
    }
    public int getExplosionWidth(){
        return explosion1[0].getWidth();
    }
    public int getExplosionHeight(){
        return explosion1[0].getHeight();
    }
}



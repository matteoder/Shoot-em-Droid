package com.example.utente.game.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.utente.game.model.*;
import com.example.utente.game.*;

public class Cannon {

    Bitmap cannon;
    float cannonX;
    static int cannonY;

    public Cannon(Context context){
        if(Startgame.tank==0)
        cannon = BitmapFactory.decodeResource(context.getResources(), R.drawable.tank);
        else if(Startgame.tank==1)
            cannon = BitmapFactory.decodeResource(context.getResources(), R.drawable.tanksepp);
        else if(Startgame.tank==2)
            cannon = BitmapFactory.decodeResource(context.getResources(), R.drawable.tankblu);
     resetPosition();

    }
    public Bitmap getBitmap(){
        return cannon;
    }
    public int getWidth(){
        return cannon.getWidth();
    }
    public int getHeight(){
        return cannon.getHeight();
    }
    public void resetPosition() {
        cannonX = GameView.dWidth/2 - getWidth()/2;
        cannonY =GameView.dHeight - getHeight() ;
    }
    }



package com.example.utente.game.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.Image;
import android.media.SoundPool;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import com.example.utente.game.*;
import com.example.utente.game.model.Gameover;
import com.example.utente.game.model.R;


import java.util.ArrayList;


public class GameView extends View {
//VALORI ED OGGETTI UTILI PER IL LIVELLO
    Bitmap background;
    Rect rect;
    static int dWidth, dHeight;
    ArrayList<Plane> planes, planes2;
    ArrayList<missile> missiles,bombs;
    ArrayList<Explosion> explosions;
    ArrayList<Cannon> cannone;
    ArrayList<Explosion2> explosions2;


    Handler handler;
    Runnable runnable;
    final long UPDATE_MILLIS = 30;

    Context context;
    int count = 0;
    //SONORO
    SoundPool sp;
    int fire = 0, point = 0 ;
    int launch =0;
    int explosion=0;
int count2=0;
//PUNTEGGIO
    Paint scorePaint;
    final int TEXT_SIZE = 60;


//COSTRUTTORE
    public GameView(Context context) {
        super(context);
        this.context = context;
        background = BitmapFactory.decodeResource(getResources(), R.drawable.backgroundgame);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rect = new Rect(0, 0, dWidth, dHeight);
        planes = new ArrayList<>();
        planes2 = new ArrayList<>();
        missiles = new ArrayList<>();
        bombs = new ArrayList<>();
        explosions=new ArrayList<>();
        explosions2=new ArrayList<>();
        cannone = new ArrayList<>();
        Cannon cannon = new Cannon(context);
        cannone.add(0,cannon);


            Bomba b = new Bomba(context);
            bombs.add(0,b);



        Plane plane = new Plane(context);
            planes.add(plane);
            Plane2 plane2 = new Plane2(context);
            planes2.add(plane2);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        fire = sp.load(context, R.raw.cannon, 1);
        point = sp.load(context, R.raw.explosion, 1);
       launch = sp.load(context, R.raw.launch2, 1);
       explosion=sp.load(context, R.raw.explosionbomb, 1);
        scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);

    }

//CANVAS
    @Override
    protected void onDraw(Canvas canvas) {
        float cannHeigth=cannone.get(0).getHeight();
        super.onDraw(canvas);
        //SFONDO
        canvas.drawBitmap(background, null, rect, null);
        //CANNONE
        canvas.drawBitmap(cannone.get(0).getBitmap(),cannone.get(0).cannonX, cannone.get(0).cannonY, null);
        //POSIZIONAMENTO AEREI-INIZIO
        for (int i = 0; i < planes.size(); i++) {
            canvas.drawBitmap(planes.get(i).getBitmap(), planes.get(i).planeX, planes.get(i).planeY, null);
            planes.get(i).planeFrame++;
            if (planes.get(i).planeFrame > 14) {
                planes.get(i).planeFrame = 0;
            }
            planes.get(i).planeX -= planes.get(i).velocity;
            if (planes.get(i).planeX < -planes.get(i).getWidth()) {
                planes.get(i).resetPosition();
            }
            canvas.drawBitmap(planes2.get(i).getBitmap(), planes2.get(i).planeX, planes2.get(i).planeY, null);
            planes2.get(i).planeFrame++;
            if (planes2.get(i).planeFrame > 9) {
                planes2.get(i).planeFrame = 0;
            }
            planes2.get(i).planeX += planes2.get(i).velocity;
            if (planes2.get(i).planeX > (dWidth + planes2.get(i).getWidth())) {
                planes2.get(i).resetPosition();
            }
        }
        //POSIZIONAMENTO AEREI--FINE


        //POSIZIONAMENTO MISSILI
       for (int i = 0; i < missiles.size(); i++) {
           if (missiles.get(i).y > -missiles.get(i).getmissileHeight()) {
               missiles.get(i).y -= missiles.get(i).mVelocity;
               canvas.drawBitmap(missiles.get(i).missile, missiles.get(i).x, missiles.get(i).y, null);

               //COLLISIONI
               if (missiles.get(i).x >= planes.get(0).planeX && (missiles.get(i).x + missiles.get(i).getmissileWidth())
                       <= (planes.get(0).planeX + planes.get(0).getWidth()) && missiles.get(i).y >= planes.get(0).planeY &&
                       missiles.get(i).y <= (planes.get(0).planeY + planes.get(0).getHeight())) {
                   Explosion explosion = new Explosion(context);
                   explosion.explosionX=planes.get(0).planeX+planes.get(0).getWidth()/2- explosion.getExplosionWidth()/2;
                   explosion.explosionY=planes.get(0).planeY+planes.get(0).getHeight()/2 - explosion.getExplosionHeight()/2;
                   explosions.add(explosion);
                   planes.get(0).resetPosition();
                   count++;
                   count2++;
                   planes.get(0).velocity=planes.get(0).velocity+0.75;
                   missiles.remove(i);
                   if (point != 0) {
                       sp.play(point, 1, 1, 0, 0, 1);
                   }

               } else if (missiles.get(i).x >= planes2.get(0).planeX && (missiles.get(i).x + missiles.get(i).getmissileWidth())
                       <= (planes2.get(0).planeX + planes2.get(0).getWidth()) && missiles.get(i).y >= planes2.get(0).planeY &&
                       missiles.get(i).y <= (planes2.get(0).planeY + planes2.get(0).getHeight())) {
                   Explosion explosion = new Explosion(context);
                   explosion.explosionX=planes2.get(0).planeX+planes2.get(0).getWidth()/2- explosion.getExplosionWidth()/2;
                   explosion.explosionY=planes2.get(0).planeY+planes2.get(0).getHeight()/2 - explosion.getExplosionHeight()/2;
                   explosions.add(explosion);
                   planes2.get(0).resetPosition();
                   count++;
                   count2++;
                   planes2.get(0).velocity=planes2.get(0).velocity+0.75;
                   missiles.remove(i);
                   if (point != 0) {
                       sp.play(point, 1, 1, 0, 0, 1);
                   }
               }
           } else {
               missiles.remove(i);
           }
       }

       //INCREMENTO DIFFICOLTA'
        if(this.count == 5 && count2==5) {
            Bomba b1 = new Bomba(context);
            b1.mVelocity = b1.mVelocity + 4;

            bombs.add(1, b1);
            count2++;
        }
        if(this.count==13 && count2==14) {
            Bomba b2 = new Bomba(context);
            b2.mVelocity = b2.mVelocity + 7;
            bombs.add(2, b2);
            count2++;
        }
        if(this.count==30 && count2==32) {
            Bomba b3 = new Bomba(context);
            b3.mVelocity = b3.mVelocity - 3;

            bombs.add(3, b3);
            count2++;
        }
        if(this.count==65 && count2==68) {
            Bomba b4 = new Bomba(context);
            b4.mVelocity = b4.mVelocity;

            bombs.add(4, b4);
            count2++;
        }

         //GESTIONE ESPLOSIONI
            for(int j=0;j<explosions.size();j++){
           canvas.drawBitmap(explosions.get(j).getExplosion(explosions.get(j).explosionFrame),explosions.get(j).explosionX,explosions.get(j).explosionY,null);
           explosions.get(j).explosionFrame++;
           if(explosions.get(j).explosionFrame>18){
               explosions.remove(j);
           }
       }

        for(int j=0;j<explosions2.size();j++){
            canvas.drawBitmap(explosions2.get(j).getExplosion(explosions2.get(j).explosionFrame),explosions2.get(j).explosionX,explosions2.get(j).explosionY,null);
            explosions2.get(j).explosionFrame++;
            if(explosions2.get(j).explosionFrame>6){
                explosions2.remove(j);
            }
        }

        //POSIZIONAMENTO BOMBE
         for(int i = 0; i < bombs.size(); i += 1) {
            if (bombs.get(i).y < dHeight) {
                bombs.get(i).y += bombs.get(i).mVelocity;
                canvas.drawBitmap(bombs.get(i).missile,bombs.get(i).x, bombs.get(i).y, null);
            }


            //ENDGAME
            if(bombs.get(i).y>=Cannon.cannonY && bombs.get(i).x <=cannone.get(0).cannonX + (cannone.get(0).getWidth()-80) && bombs.get(i).x>=cannone.get(0).cannonX - (cannone.get(0).getWidth() / 4)+50){
                bombs.remove(i);
                Intent intent = new Intent(context,Gameover.class);
                intent.putExtra("score",(count));
                context.startActivity(intent);
                ((Activity) context).finish();



                //ESPLOSIONE BOMBE
            }else if(bombs.get(i).y>dHeight-285) {
                Explosion2 explosion2 = new Explosion2(context);
                explosion2.explosionX= (int) (bombs.get(i).x+bombs.get(i).getmissileWidth()/2- explosion2.getExplosionWidth()/2);
                explosion2.explosionY= dHeight-530;
                explosions2.add(explosion2);
                sp.play(explosion, 1, 1, 0, 0, 1);
                bombs.get(i).resetPosition();


            }

        }





        canvas.drawText("Pt: " + (count), 0, TEXT_SIZE, scorePaint);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }


    //GESTIONE EVENTI TOUCH
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int action = event.getAction();
        switch (action) {


            case MotionEvent.ACTION_DOWN:
                if(touchX<=cannone.get(0).cannonX + (cannone.get(0).getWidth()-80) && touchX>=(cannone.get(0).cannonX - (cannone.get(0).getWidth() / 4)+50) && touchY>=Cannon.cannonY) {


                    if (missiles.size() < 1) {
                        missile m = new missile(context);
                        m.x=cannone.get(0).cannonX + cannone.get(0).getWidth() / 2;
                        missiles.add(m);
                        if (fire != 0) {
                            sp.play(fire, 1, 1, 0, 0, 1);
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("Tank", "moving");

                    cannone.get(0).cannonX = touchX- cannone.get(0).getWidth() / 2;

                break;

        }

            return true;

    }
}

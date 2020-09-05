package com.example.utente.game.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

import com.example.utente.game.model.R;

public class Bomba extends missile {

    public Bomba(Context context) {
        super(context);
        random=new Random();

        missile = BitmapFactory.decodeResource(context.getResources(), R.drawable.missile3trsp);

        mVelocity = 20;
        resetPosition();
    }

}

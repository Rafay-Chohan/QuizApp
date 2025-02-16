package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    //Hooks
    Animation bottom_to_top;
    ImageView ivLogo;
    TextView tvSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Function to initialize Hooks etc
        init();

        //Attaching Annimation to the hook
        bottom_to_top = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);

        //Attaching Annimation to the objects
        ivLogo.setAnimation(bottom_to_top);
        tvSubtitle.setAnimation(bottom_to_top);

        //Handler Starts the Activity after a delay
        new Handler()
                .postDelayed(()->{
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }, 4000);

    }
    private void init(){
        ivLogo = findViewById(R.id.ivLogo);
        tvSubtitle = findViewById(R.id.tvSubtitle);
    }

}
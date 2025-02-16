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

    Animation bottom_to_top;
    ImageView ivLogo;
    TextView tvSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        
        
        ivLogo = findViewById(R.id.ivLogo);
        tvSubtitle = findViewById(R.id.tvSubtitle);

        bottom_to_top = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);

        ivLogo.setAnimation(bottom_to_top);
        tvSubtitle.setAnimation(bottom_to_top);

        new Handler()
                .postDelayed(()->{
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }, 4000);

    }

}
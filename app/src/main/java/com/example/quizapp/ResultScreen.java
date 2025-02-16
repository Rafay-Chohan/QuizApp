package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    //Hooks
    int result;
    String username;
    Button btnShare,btnBack;
    TextView tvResult,tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        //Function to initialize Hooks etc
        init();

        username=getIntent().getStringExtra("username");
        result=getIntent().getIntExtra("result",0);
        tvUsername.setText(username);
        tvResult.setText(result+"/10");

        btnBack.setOnClickListener(v->{
            Intent i= new Intent(ResultScreen.this,MainActivity.class);
            startActivity(i);
            finish();
        });
        btnShare.setOnClickListener(v->shareScore());

    }
    private void init()
    {
        btnBack=findViewById(R.id.btnBack);
        btnShare=findViewById(R.id.btnShare);
        tvResult=findViewById(R.id.tvresult);
        tvUsername=findViewById(R.id.tvUsername);

    }
    //implicit Calling of Activity to share score
    private void shareScore() {
        String message = username+" just got " + result + "/10 Score in Quiz App!!";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(intent, "Share via"));
    }
}
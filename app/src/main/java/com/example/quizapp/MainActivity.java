package com.example.quizapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnStart.setOnClickListener(V->{
            if(etName.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
            }
            else {
                Intent i = new Intent(this, Quiz1Activity.class);
                i.putExtra("username",etName.getText().toString());
                startActivity(i);
                finish();
            }
        });

    }
    private void init(){
        btnStart=findViewById(R.id.btnStart);
        etName=findViewById(R.id.etName);

    }
}
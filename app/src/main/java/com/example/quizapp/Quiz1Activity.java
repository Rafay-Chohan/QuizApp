package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1Activity extends AppCompatActivity {

    RadioGroup rgoptions;
    String username;
    int Result=0;
    RadioButton rbbuttonA,rbbuttonB,rbbuttonC,rbbuttonD;
    TextView tvQuestion,tvTitle;
    int pos=0;
    String[] Questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "How many legs does a spider have?",
            "What is 5 + 7?",
            "Which animal is known as the King of the Jungle?",
            "What is the color of the sky on a clear day?",
            "Which gas do plants absorb from the atmosphere?",
            "What is the largest mammal on Earth?",
            "Which shape has four equal sides?",
            "How many days are there in a week?"};

    String[] OptionA = {"Berlin", "Earth", "6", "10", "Tiger", "Green", "Oxygen", "Elephant", "Triangle", "5"};

    String[] OptionB = {"Madrid", "Venus", "8", "12", "Lion", "Blue", "Carbon Dioxide", "Blue Whale", "Square", "7"};

    String[] OptionC = {"Paris", "Mars", "4", "14", "Bear", "Red", "Nitrogen", "Dolphin", "Circle", "6"};

    String[] OptionD = {"Rome", "Jupiter", "10", "11", "Cheetah", "Yellow", "Helium", "Shark", "Rectangle", "8"};

    String[] Answers = {"Paris", "Mars", "8", "12", "Lion", "Blue", "Carbon Dioxide", "Blue Whale", "Square", "7"};
    String []UserSelected={"","","","","","","","","",""};
    Button btnNext,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username =getIntent().getStringExtra("username");
        setContentView(R.layout.activity_quiz1);

        init();
        btnNext.setOnClickListener((v)->{
            int id = rgoptions.getCheckedRadioButtonId();
            if(id!=-1)
            {
                RadioButton rbOption = findViewById(id);
                String textOfRadioButton = rbOption.getText().toString();
                UserSelected[pos]=textOfRadioButton;
                pos=pos+1;
                if(pos==9){
                    goNext();
                    btnNext.setText("Finish");
                } else if (pos==10) {
                    checkResult();
                    Intent i = new Intent(Quiz1Activity.this, ResultScreen.class);
                    i.putExtra("username", username);
                    i.putExtra("result", Result);
                    startActivity(i);
                    finish();
                }
                else{
                    goNext();
                }
            }
            else{
                Toast.makeText(Quiz1Activity.this,"Please Select an Option",Toast.LENGTH_SHORT).show();
            }

        });

        btnBack.setOnClickListener(v->{
            pos=pos-1;
            goNext();
        });
    }
    private void checkResult(){
        for(int i=0;i<Answers.length;i++){
            if(Answers[i].equals(UserSelected[i]))
                Result=Result+1;
        }
    }
    private void goNext(){
        rgoptions.clearCheck();
        if(pos!=0)
        {
            btnBack.setVisibility(View.VISIBLE);
        }
        else{
            btnBack.setVisibility(View.GONE);
        }
        tvTitle.setText((pos+1)+"/10");
        tvQuestion.setText(Questions[pos]);
        rbbuttonA.setText(OptionA[pos]);
        rbbuttonB.setText(OptionB[pos]);
        rbbuttonD.setText(OptionD[pos]);
        rbbuttonC.setText(OptionC[pos]);
    }
    private void init(){
        ;
        btnNext=findViewById(R.id.btnNext);
        btnBack=findViewById(R.id.btnQuestionBack);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvTitle=findViewById(R.id.tvTitle);
        rgoptions=findViewById(R.id.rgOptions);
        rbbuttonA=findViewById(R.id.rboptionA);
        rbbuttonB=findViewById(R.id.rboptionB);
        rbbuttonC=findViewById(R.id.rboptionC);
        rbbuttonD=findViewById(R.id.rboptionD);
        goNext();
    }
}
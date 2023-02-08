package com.example.typeit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView DisplayedWords, GameResult;
    EditText EnteredWords;
    Button ResetBtn;
    String fullStory;
    Button donebtn;
    long BeginTime, StopTime;
    boolean gameBegan = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        donebtn = findViewById(R.id.donebtn);
        donebtn.setOnClickListener(view-> {
            Intent intent = new Intent(TestActivity.this, extraPage.class);
            startActivity(intent);
        });


        DisplayedWords = (TextView) findViewById(R.id.DisplayedWords);
        GameResult = (TextView) findViewById(R.id.GameResult);
        EnteredWords = (EditText) findViewById(R.id.EnteredWords);
        ResetBtn = (Button) findViewById(R.id.resetbtn);
        fullStory = DisplayedWords.getText().toString();

        EnteredWords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String currentStory = EnteredWords.getText().toString();

                //startedTask
                if(currentStory.length() ==1 && ! gameBegan ){
                    BeginTime = System.currentTimeMillis();
                    GameResult.setText("Test began");
                    gameBegan = true;
                }
                //EndedTask
                if(currentStory.equals(fullStory)){
                    StopTime = System.currentTimeMillis();

                    long currentTime = (StopTime - BeginTime) / 1000;
                    GameResult.setText("Finished in " + currentTime + " seconds");

                    EnteredWords.setEnabled(false);
                    EnteredWords.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnteredWords.setEnabled(true);
                EnteredWords.setText("");
                GameResult.setText("");
                gameBegan = false;
            }
        });

    }
}
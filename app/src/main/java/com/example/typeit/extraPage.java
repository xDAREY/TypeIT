package com.example.typeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class extraPage extends AppCompatActivity {
    Button back;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_page);

        back = findViewById(R.id.backbtn);
        back.setOnClickListener(view-> {
            Intent intent = new Intent(extraPage.this, TestActivity.class);
            startActivity(intent);
        });

        done = findViewById(R.id.donebtn);
        done.setOnClickListener(view-> {
            Intent intent = new Intent(extraPage.this, exit.class);
            startActivity(intent);
        });

    }
}


package com.example.pacotesdeviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacotesdeviagens.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, ListaPacotesActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }


}
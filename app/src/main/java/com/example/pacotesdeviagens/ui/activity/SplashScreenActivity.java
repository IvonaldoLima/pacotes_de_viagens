package com.example.pacotesdeviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacotesdeviagens.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    public static final String CHAVE_SPLASH_JA_FOI_MOSTRADO = "ja_abriu_app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        verificaSeOSplashJaFoiMostrado();
    }

    private void verificaSeOSplashJaFoiMostrado() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        if (preferences.contains(CHAVE_SPLASH_JA_FOI_MOSTRADO))
            mostrarListaPacotes();
        else {
            adicionarPreferenceJaAbriu(preferences);
            mostrarSplashScreen();
        }
    }

    private void mostrarSplashScreen() {
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarListaPacotes();
            }
        }, 2000);
    }

    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("ja_abriu_app", true);
        editor.commit();
    }

    private void mostrarListaPacotes() {
        Intent intent = new Intent(SplashScreenActivity.this, ListaPacotesActivity.class);
        startActivity(intent);
    }


}
package com.example.myedpsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int SPLASH_DISPLAY_LENGTH = 1500;

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent mainToSecondIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(mainToSecondIntent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
            finish();
        }, SPLASH_DISPLAY_LENGTH);


    }
//テスト
}
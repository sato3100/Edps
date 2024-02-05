package com.example.myedpsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int x = 5;
    if(x > 0){
        System.out.println("Windowsからテスト  ori");
        System.out.println("Macからテスト  ori");
        System.out.println("Macからテスト  tupi");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EighthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleventh);

        findViewById(R.id.dishImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //アクティビティスタック上の位置が保持される
                Intent intent = new Intent(EighthActivity.this, NinthActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
            }
        });








    }







}

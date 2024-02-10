package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SeventhActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenth);

        findViewById(R.id.eatStartButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
            @Override
            public void onClick(View v) {

                Intent SeventhToEighthIntent = new Intent(SeventhActivity.this, EighthActivity.class);//一時的にrakutenから変更
                // 名前を渡す
                startActivity(SeventhToEighthIntent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // FourthActivityを終了させる

            }
        });


    }
}

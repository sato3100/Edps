package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        findViewById(R.id.ingredientButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
            @Override
            public void onClick(View v) {

                Intent FourthToFifthIntent = new Intent(FourthActivity.this, Rakuten.class);//一時的に変更
                // 名前を渡す
                startActivity(FourthToFifthIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
            }
        });
        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //アクティビティスタック上の位置が保持される
                Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
            }
        });




    }
}


package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth);

        try {
            findViewById(R.id.readyButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
                @Override
                public void onClick(View v) {

                    Intent FifthToSixthIntent = new Intent(FifthActivity.this, SixthActivity.class);
                    // 名前を渡す
                    startActivity(FifthToSixthIntent);

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                    finish(); // FifthActivityを終了させる

                }
            });

            findViewById(R.id.ingredientBackButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent FifthToFourthIntent = new Intent(FifthActivity.this, FourthActivity.class);
                    // 名前を渡す
                    startActivity(FifthToFourthIntent);

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                    finish(); // FifthActivityを終了させる
                }
            });




        }catch (Exception e){

        }



    }


}

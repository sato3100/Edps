package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FourthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        findViewById(R.id.iButton).setOnClickListener(new View.OnClickListener() {//食材選ぶ画面でボタン押したときの処理
            @Override
            public void onClick(View v) {

                Intent FourthToRakutenIntent = new Intent(FourthActivity.this, Rakuten.class);//一時的にrakutenから変更
                // 名前を渡す
                startActivity(FourthToRakutenIntent);

               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                //finish(); // FourthActivityを終了させる

            }
        });
        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // FourthActivityを終了させる
            }
        });




    }
}


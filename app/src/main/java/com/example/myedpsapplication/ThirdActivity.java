package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThirdActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewAge;

    private DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        findViewById(R.id.character_image).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {//リスクリック時の処理
                ImageView petImage = findViewById(R.id.character_image);
                petImage.setImageResource(R.drawable.baby2);
                new Handler().postDelayed(count,1000);//1000ミリ秒（1秒)後に元の状態に戻す

            }
            private final Runnable count = new Runnable() {//元の状態に戻す処理
                @Override
                public void run() {
                    ImageView petImage = findViewById(R.id.character_image);
                    petImage.setImageResource(R.drawable.baby);
                }
            };
        });

        findViewById(R.id.dishesButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
            @Override
            public void onClick(View v) {

                Intent ThirdToFourthIntent = new Intent(ThirdActivity.this, FourthActivity.class);
                 // 名前を渡す
                startActivity(ThirdToFourthIntent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
              //  finish(); // ThirdActivityを終了させる

            }
        });

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);

        // Firebase Realtime Databaseの参照を取得
        userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        // IntentからuserIdを取得
        String userId = getIntent().getStringExtra("USER_ID");

        // userIdを使ってFirebase Realtime Databaseから名前と年齢を取得
        userDbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // データが存在する場合、名前と年齢を取得して表示
                    Users user = dataSnapshot.getValue(Users.class);
                    String name = user.getName();
                    String age = user.getAge();
                    textViewName.setText(name);
                    textViewAge.setText(String.format("%s歳", age));
                } else {
                    // データが存在しない場合、エラーメッセージを表示などの処理を行う
                    textViewName.setText("名前が見つかりません");
                    textViewAge.setText("年齢が見つかりません");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // エラー処理
                textViewName.setText("エラー: " + databaseError.getMessage());
                textViewAge.setText("エラー: " + databaseError.getMessage());
            }

        });
    }
}




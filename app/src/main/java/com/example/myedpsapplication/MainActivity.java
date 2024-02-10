package com.example.myedpsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 以前にユーザーのデータが保存されているかどうかを確認
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String userId = prefs.getString("userId", "1");

        userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        int SPLASH_DISPLAY_LENGTH = 1500;
        userDbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                        finish(); // MainActivityを終了
                    }, SPLASH_DISPLAY_LENGTH);
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        Intent mainToSecondIntent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(mainToSecondIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                        finish();
                    }, SPLASH_DISPLAY_LENGTH);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });



    }

}

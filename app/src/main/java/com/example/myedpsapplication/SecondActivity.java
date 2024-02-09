package com.example.myedpsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    EditText etName;
    Button btnInsertData;

    DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second); // 2番目の画面遷移

        etName = findViewById(R.id.editTextName);
        btnInsertData = findViewById(R.id.buttonSubmit);

        userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");//firebaseのデーターベースにユーザーという要素を追加

        //クリック時、データベースにユーザーが追加される関数を呼ぶ
        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUserData();
            }
        });

    }

    //データベースにユーザーが追加される関数


    // データベースにユーザーが追加された後、ThirdActivityに遷移する
    private void insertUserData() {
        String name = etName.getText().toString();
        Users users = new Users(name);

        String userId = userDbRef.push().getKey();
        userDbRef.child(userId).setValue(users)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // データベース挿入成功時にThirdActivityへ遷移
                        Intent secondToThirdIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                        secondToThirdIntent.putExtra("userName", name); // 名前を渡す
                        startActivity(secondToThirdIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                        finish(); // SecondActivityを終了させる
                    } else {
                        // エラーが発生した場合
                        Toast.makeText(SecondActivity.this, "データベースに挿入ができていない。", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
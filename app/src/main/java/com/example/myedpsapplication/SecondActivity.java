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
    private void insertUserData(){

        String name = etName.getText().toString();

        Users users = new Users(name);

        String userId = userDbRef.push().getKey();
        assert userId != null;
        userDbRef.child(userId).setValue(users);

        Toast.makeText(SecondActivity.this,"名前が決まりました！",Toast.LENGTH_SHORT).show();

    }

}
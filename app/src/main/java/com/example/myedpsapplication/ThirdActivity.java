package com.example.myedpsapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third); // 画面遷移3

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);

        // Intentから名前を取得して表示
        String name = getIntent().getStringExtra("userName");
        // 年齢を取得、もしnullならデフォルト値「1」を使用
        String age = getIntent().getStringExtra("userAge");
        if (age == null) {
            age = "1"; // デフォルト値として「1歳」とする
        }

        // 名前がnullでないことを確認
        if (name != null) {
            updateNameAndAge(name, age);
        } else {
            // ここでエラーメッセージを表示するなどの処理を行います。
            // 例: Toast.makeText(this, "名前のデータがありません。", Toast.LENGTH_LONG).show();
        }
    }

    // 名前と年齢を更新するプライベートメソッド
    private void updateNameAndAge(String name, String age) {
        textViewName.setText(name);
        textViewAge.setText(String.format("%s歳", age));
    }
}



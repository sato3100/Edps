package com.example.myedpsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // このメソッドはActivityのライフサイクルには属さないため、ここに直接コードを記述することはできません。
    // 代わりに、onCreateメソッド内や他の適切な場所にログ出力のコードを配置する必要があります。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ログを使用してメッセージを出力　消していい
        Log.d("MainActivity", "Windowsからテスト  ori");
        Log.d("MainActivity", "Macからテスト  ori");
        Log.d("MainActivity", "Macからテスト  tupi");

        //ここにプログラムを書いていくみたい
    }
}

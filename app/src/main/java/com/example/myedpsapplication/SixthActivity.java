package com.example.myedpsapplication;


import android.content.Intent;
import android.media.TimedText;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class SixthActivity extends AppCompatActivity {
    private Handler  tHandler;
    private Timer timer;
     int h=0;
     int m=0;
     int s=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.seventh);


            try{

                tHandler = new Handler(getMainLooper());
                timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        tHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                s++;
                                m+=s/60;
                                h+=m/60;
                                s%=60;
                                m%=60;
                                TextView time = findViewById(R.id.timer);
                                time.setText(h+":"+m+":"+s);
                            }
                        });}
                    },0,1000);





                findViewById(R.id.cookFinishButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
                    @Override
                    public void onClick(View v) {

                        WebView webView = findViewById(R.id.webview); // XML で定義した WebView の ID
                        String recipeUrl = getIntent().getStringExtra("RECIPE_URL");

                        webView.getSettings().setJavaScriptEnabled(true); // 必要に応じて JavaScript を有効にする
                        webView.loadUrl(recipeUrl);

                        int time = h*3600+m*60+s;//画面遷移で渡したいデータ

                        Intent SixthToSeventhIntent = new Intent(SixthActivity.this, SeventhActivity.class);
                        SixthToSeventhIntent.putExtra("time", time);

                        Intent SixthToCameraIntent = new Intent(SixthActivity.this, CameraActivity.class);
                        // 名前を渡す


                        startActivity(SixthToCameraIntent);




                       // overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                        finish(); // FourthActivityを終了させる

                    }
                });


            }catch (Exception e){

            }




        }

}

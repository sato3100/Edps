package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NinthActivity extends AppCompatActivity {

    private Handler tHandler;
    private Timer timer;
    int m=10;
    int s=59;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twelfth);


        tHandler = new Handler(getMainLooper());
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        s++;
                        m-=s/60;


                        s%=60;
                        TextView time = findViewById(R.id.eatTimer);
                        time.setText("残り："+m+"分"+(59-s)+"秒");
                        //if(m==0 &&s==59){//本番環境(10分で遷移
                        if(m==9 &&s==10){//10秒で遷移
                            Intent intent = new Intent(NinthActivity.this, TenthActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                        }
                    }

                });}
        },0,1000);



    }
}

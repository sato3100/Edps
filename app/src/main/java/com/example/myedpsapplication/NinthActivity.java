package com.example.myedpsapplication;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NinthActivity extends AppCompatActivity {

    private Handler tHandler;
    private Timer timer;
    int m=10;
    int s=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twelfth);
        Intent cameraIntent =getIntent();
        String dish =cameraIntent.getStringExtra("EXTRA");



        tHandler = new Handler(getMainLooper());
        timer = new Timer();
        ImageView dishImg = findViewById(R.id.eatenDishImg);
        // dishImg.setImageResource();
        ScaleAnimation dScale = new ScaleAnimation(1,0,1,0,0.5f,0.5f);
        dScale.setDuration(10000);//10分 600000 ミリ秒  10秒 10000
        //dScale.setInterpolator(new AnticipateOvershootInterpolator());
        dishImg.startAnimation(dScale);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        s--;
                        if(s<0){
                            s=59;
                            m--;

                        }

                        TextView time = findViewById(R.id.eatTimer);
                        time.setText("残り："+m+"分"+s+"秒");
                        //if(m==0 &&s==0){//本番環境(10分で遷移
                        if(m==9 &&s==50){//10秒で遷移
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

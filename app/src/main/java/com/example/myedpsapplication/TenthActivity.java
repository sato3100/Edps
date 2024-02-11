package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TenthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirteenth);

        findViewById(R.id.cleanButton).setOnClickListener(new View.OnClickListener() {//食材選ぶ画面でボタン押したときの処理
            @Override
            public void onClick(View v) {

                ImageView dDishImg = findViewById(R.id.dirtyDish);
               // dDishImg.animateTransform(1,0);
                AlphaAnimation dAnim = new AlphaAnimation(1,0);
                dAnim.setDuration(2000);
                dAnim.setInterpolator(new LinearInterpolator());
                dDishImg.startAnimation(dAnim);
                dDishImg.setVisibility(View.INVISIBLE);
                ImageView petImage = findViewById(R.id.character_image);

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent = new Intent(TenthActivity.this, ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション


                    },3200);
                petImage.setImageResource(R.drawable.baby2);

                //アクティビティスタック上の位置が保持される

            }
        });
    }
}

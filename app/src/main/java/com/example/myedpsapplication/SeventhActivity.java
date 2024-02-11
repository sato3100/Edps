package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SeventhActivity extends AppCompatActivity {

    Intent getTime = getIntent();




    //ImageView petImage = findViewById(R.id.character_image);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenth);

        //String time = getIntent().getStringExtra("time");
       // int timeScore=getTimeValue;

    //    TextView ScoreText = findViewById(R.id.evaluationText);
   //     ScoreText.setText(timeScore);
        TextView evText = findViewById(R.id.evaluationText);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            AlphaAnimation eAnim = new AlphaAnimation(0,1);
            eAnim.setDuration(2000);
            eAnim.setInterpolator(new LinearInterpolator());
            evText.startAnimation(eAnim);
            evText.setVisibility(View.VISIBLE);

        },2000);







        findViewById(R.id.eatStartButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                Intent SeventhToEighthIntent = new Intent(SeventhActivity.this, EighthActivity.class);

                // 名前を渡す
                startActivity(SeventhToEighthIntent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // SeventhActivityを終了させる

            }
        });


    }
}

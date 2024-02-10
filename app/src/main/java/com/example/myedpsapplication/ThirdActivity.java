package com.example.myedpsapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThirdActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewAge;

    private DatabaseReference userDbRef;
    int petAnimation=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        findViewById(R.id.character_image).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                long startTime = System.currentTimeMillis();
                long endTime;
                ImageView petImage = findViewById(R.id.character_image);
                petImage.setImageResource(R.drawable.baby2);



                for(int i=0;;i++){
                    endTime=System.currentTimeMillis();
                    if(endTime-startTime==1000){
                        petImage.setImageResource(R.drawable.baby);
                        break;
                    }
                }

            }
        });

        try{

            textViewName = findViewById(R.id.textViewName);
            textViewAge = findViewById(R.id.textViewAge);

            // Firebase Realtime Databaseの参照を取得
            userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

            // IntentからuserIdを取得
            String userId = getIntent().getStringExtra("USER_ID");

            // userIdを使ってFirebase Realtime Databaseから名前と年齢を取得
            userDbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // データが存在する場合、名前と年齢を取得して表示
                        Users user = dataSnapshot.getValue(Users.class);
                        String name = user.getName();
                        String age = user.getAge();
                        textViewName.setText(name);
                        textViewAge.setText(String.format("%s歳", age));
                    } else {
                        // データが存在しない場合、エラーメッセージを表示などの処理を行う
                        textViewName.setText("名前が見つかりません");
                        textViewAge.setText("年齢が見つかりません");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // エラー処理
                    textViewName.setText("エラー: " + databaseError.getMessage());
                    textViewAge.setText("エラー: " + databaseError.getMessage());
                }








            });

        }catch (Exception e){
            Log.e(e.toString(),e.toString());
        }




    }
}




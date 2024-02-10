package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rakuten extends AppCompatActivity {

   // private final String BASE_URL = "https://app.rakuten.co.jp/services/api/Recipe/CategoryLis\n" + "  t/20170426?\n" + "applicationId=[1087356199907491193]& categoryType=large";

   // private final String BASE_URL = "https://app.rakuten.co.jp/services/api/Recipe/CategoryList/20170426?applicationId=1087356199907491193";
  //  private  final  String  BASE_URL = "https://app.rakuten.co.jp/services/api/Recipe/CategoryList/20170426/";
   private  final  String  BASE_URL ="https://app.rakuten.co.jp/services/api/";
   private final String APPLICATION_ID = "1087356199907491193"; // あなたのAPIキーを設定



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth);

        //try{
        //    Retrofit retrofit = new Retrofit.Builder()
         //           .baseUrl(BASE_URL)
        //            .addConverterFactory(GsonConverterFactory.create())
        //            .build();

        //    RakutenRecipeApi api = retrofit.create(RakutenRecipeApi.class);

        //    Call<RecipeResponse> call = api.getRecipes(APPLICATION_ID, "20"); // カテゴリIDを設定

          //  call.enqueue(new Callback<RecipeResponse>() {
            //      @Override
            //    public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
            //        //TextView t = findViewById(R.id.textViewRecipe1);

            //        if (response.isSuccessful()) {
                        // レスポンスを処理
            //            RecipeResponse recipeResponse = response.body();

                        // レシピ情報を取得
            //            List<RecipeResponse.Recipe> recipes = recipeResponse.getResult();

            //            for (int i= 0; i < recipes.size(); i++) {
            //                RecipeResponse.Recipe recipe = recipes.get(i);

                            // sixth.xmlから拾ってきてる
            //                TextView recipeTextView = findViewById(getResources().getIdentifier("textViewRecipe" + (i + 1), "id", getPackageName()));
            //                recipeTextView.setText(recipe.getRecipeTitle());

                            // 上と同じくで、画像出るはず
             //               ImageView recipeImageView = findViewById(getResources().getIdentifier("imageViewRecipe" + (i + 1), "id", getPackageName()));

                            // Glideを使用して画像をロード
             //               Glide.with(Rakuten.this)
            //                        .load(recipe.getFoodImageUrl())
            //                        .into(recipeImageView);
            //            }


                        // UIに表示
           //             StringBuilder stringBuilder = new StringBuilder();
            //            for (RecipeResponse.Recipe recipe : recipes) {
            //                stringBuilder.append("レシピ名: ").append(recipe.getRecipeTitle()).append("\n");
            //                stringBuilder.append("画像URL: ").append(recipe.getFoodImageUrl()).append("\n");
            //                stringBuilder.append("-----------------------------------\n");
            //            }
                      //  t.setText(stringBuilder.toString());

             //       } else {
                        // エラー処理
                       // t.setText("エラーが発生しました。");
            //        }
            //    }


            //    @Override
            //    public void onFailure(Call<RecipeResponse> call, Throwable t) {
                    // エラー処理
                 //   TextView t2 = findViewById(R.id.textView4);
                //    t2.setText("ヘラった");
            //    }
            //});
        //}catch (Exception e){

        //}




        findViewById(R.id.readyButton).setOnClickListener(new View.OnClickListener() {//食器ボタン押したときの処理
            @Override
            public void onClick(View v) {

                Intent FifthToSixthIntent = new Intent(Rakuten.this, SixthActivity.class);
                // 名前を渡す
                startActivity(FifthToSixthIntent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // FifthActivityを終了させる

            }
        });

        findViewById(R.id.ingredientBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // FifthActivityを終了させる
            }
        });





    }

}

package com.example.myedpsapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        try{
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RakutenRecipeApi api = retrofit.create(RakutenRecipeApi.class);

            Call<RecipeResponse> call = api.getRecipes(APPLICATION_ID, "20"); // カテゴリIDを設定

            call.enqueue(new Callback<RecipeResponse>() {
                @Override
                public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                    TextView t = findViewById(R.id.textView4);

                    if (response.isSuccessful()) {
                        // レスポンスを処理
                        RecipeResponse recipeResponse = response.body();

                        // レシピ情報を取得
                        List<RecipeResponse.Recipe> recipes = recipeResponse.getResult();

                        // UIに表示
                        StringBuilder stringBuilder = new StringBuilder();
                        for (RecipeResponse.Recipe recipe : recipes) {
                            stringBuilder.append("レシピ名: ").append(recipe.getRecipeTitle()).append("\n");
                            stringBuilder.append("画像URL: ").append(recipe.getFoodImageUrl()).append("\n");
                            stringBuilder.append("-----------------------------------\n");
                        }
                        t.setText(stringBuilder.toString());

                    } else {
                        // エラー処理
                        t.setText("エラーが発生しました。");
                    }
                }


                @Override
                public void onFailure(Call<RecipeResponse> call, Throwable t) {
                    // エラー処理
                    TextView t2 = findViewById(R.id.textView4);
                    t2.setText("ヘラった");
                }
            });
        }catch (Exception e){
            TextView t = findViewById(R.id.textView4);
            t.setText(e.toString());
        }



    }

}

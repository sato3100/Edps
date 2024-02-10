package com.example.myedpsapplication;

import android.content.Intent;
import android.os.Bundle;
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

    private final String BASE_URL = "https://app.rakuten.co.jp/services/api/";
    private final String APPLICATION_ID = "1087356199907491193"; // あなたのAPIキー

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RakutenRecipeApi api = retrofit.create(RakutenRecipeApi.class);

        Call<RecipeResponse> call = api.getRecipes(APPLICATION_ID, "20"); // カテゴリIDを設定

        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // レスポンスを処理
                    List<RecipeResponse.Recipe> recipes = response.body().getResult();

                    for (int i = 0; i < recipes.size(); i++) {
                        RecipeResponse.Recipe recipe = recipes.get(i);
                        int recipeTextViewID = getResources().getIdentifier("textViewRecipe" + (i + 1), "id", getPackageName());
                        int recipeImageViewID = getResources().getIdentifier("imageViewRecipe" + (i + 1), "id", getPackageName());

                        TextView recipeTextView = findViewById(recipeTextViewID);
                        ImageView recipeImageView = findViewById(recipeImageViewID);

                        if (recipeTextView != null) {
                            recipeTextView.setText(recipe.getRecipeTitle());
                        }

                        if (recipeImageView != null) {
                            Glide.with(Rakuten.this).load(recipe.getFoodImageUrl()).into(recipeImageView);
                        }
                    }
                } else {
                    showError("レシピ情報の取得に失敗してる");
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                showError("通信エラーが発生：" + t.getMessage());
            }
        });

        findViewById(R.id.readyButton).setOnClickListener(v -> {
            Intent intent = new Intent(Rakuten.this, SixthActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });

        findViewById(R.id.ingredientBackButton).setOnClickListener(v -> {
            Intent intent = new Intent(Rakuten.this, FourthActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });
    }

    private void showError(String errorMessage) {
        TextView errorTextView = findViewById(R.id.textViewRecipe1);//仮でこのidにしてる
        if (errorTextView != null) {
            errorTextView.setText(errorMessage);
        }
    }
}

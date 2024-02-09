package com.example.myedpsapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rakuten extends AppCompatActivity {

    private final String BASE_URL = "https://app.rakuten.co.jp/services/api/Recipe/CategoryLis\n" + "  t/20170426?\n" + "applicationId=[1087356199907491193]& categoryType=large";
    private final String APPLICATION_ID = "f620061daa80949337fb24cebf3c94fe8398db64"; // あなたのAPIキーを設定

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RakutenRecipeApi api = retrofit.create(RakutenRecipeApi.class);

        Call<RecipeResponse> call = api.getRecipes(APPLICATION_ID, "カテゴリID"); // カテゴリIDを設定

        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    // レスポンスを処理
                    RecipeResponse recipeResponse = response.body();
                    // ここでレシピ情報をUIに表示
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                // エラー処理
            }
        });
    }
}

package com.example.myedpsapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RakutenRecipeApi {
    @GET("Recipe/CategoryRanking/20170426")
    Call<RecipeResponse> getRecipes(@Query("applicationId") String appId, @Query("categoryId") String categoryId);
}

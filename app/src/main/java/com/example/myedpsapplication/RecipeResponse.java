package com.example.myedpsapplication;

import java.util.List;

public class RecipeResponse {
    // このクラスはAPIのレスポンス構造に合わせて定義してください。
    // 以下は一例です。
    public List<Recipe> result;

    public static class Recipe {
        public String recipeTitle;
        public String foodImageUrl;
        public String recipeUrl;
        // 必要に応じて他のフィールドを追加
    }
}

package com.example.myedpsapplication;

import java.util.List;

public class RecipeResponse {
    private List<Recipe> result;

    public List<Recipe> getResult() {
        return result; // Return the actual result
    }

    public static class Recipe {
        private String recipeTitle;
        private String foodImageUrl;
        // Add the getter for recipeUrl if you're using it
        private String recipeUrl;

        public String getRecipeTitle() {
            return recipeTitle; // Return the actual title
        }

        public String getFoodImageUrl() {
            return foodImageUrl; // Return the actual image URL
        }

        // Getter for recipeUrl
        public String getRecipeUrl() {
            return recipeUrl;
        }
    }
}

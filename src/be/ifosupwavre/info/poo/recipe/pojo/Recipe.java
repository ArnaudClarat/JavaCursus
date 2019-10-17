package be.ifosupwavre.info.poo.recipe.pojo;

import java.util.HashSet;
import java.util.Set;

public class Recipe {
    private String title;
    private String subtitle;
    private Category category;
    private Difficulty difficulty;
    private int time;
    private int expDay;
    private Set<Ingredient> ingredients;

    /* TODO
        addIngredient()
        removeIngredient()
        updateIngredient()
        showIngredient(numberOfPerson)
        ...
     */

    public Recipe(String title, String subtitle, Category category, Difficulty difficulty, int time, int expDay, Set<Ingredient> ingredients) {
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.difficulty = difficulty;
        this.time = time;
        this.expDay = expDay;
        this.ingredients = ingredients;
    }

    public Recipe(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    private Recipe() {
        this.ingredients = new HashSet<>();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getExpDay() {
        return expDay;
    }

    public void setExpDay(int expDay) {
        this.expDay = expDay;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    private void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private void addIngredient(Ingredient ingredient){}

    @Override
    public String toString() {
        return title + ", " + subtitle + ", " + category;
        //return MessageFormat.format("{} {} {}", title, subtitle, category);
    }

     public static class Builder{
        private Recipe recipe = new Recipe();

        public Builder putTitle(String title){
            recipe.setTitle(title);
            return this;
        }

        public Builder putSubTitle(String subtitle){
            recipe.setSubtitle(subtitle);
            return this;
        }

        public Builder putCategory(Category category){
            recipe.setCategory(category);
            return this;
        }

        public Builder putDifficulty(Difficulty difficulty){
            recipe.setDifficulty(difficulty);
            return this;
        }

        public Builder putTime(int time){
            recipe.setTime(time);
            return this;
        }

        public Builder putExpDay(int day){
            recipe.setExpDay(day);
            return this;
        }

        public Builder addIngredients(Ingredient... ingredients){
            for(Ingredient ingredient : ingredients){
                recipe.addIngredient(ingredient);
            }
            return this;
        }

        public Recipe build(){
            return recipe;
        }
    }
}

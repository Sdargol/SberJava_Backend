package org.sdargol.model;

import java.util.List;

public class DishBuilder {
    private int id;
    private String name;
    private List<Ingredient> ingredients;

    public DishBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DishBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DishBuilder setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
        return this;
    }

    public Dish build(){
        return new Dish(id,name,ingredients);
    }

}

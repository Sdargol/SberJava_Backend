package org.sdargol.model;

public class IngredientBuilder {
    private int id;
    private int count;
    private String name;
    private String dishName;

    public IngredientBuilder setId(int id){
        this.id = id;
        return this;
    }

    public IngredientBuilder setCount(int count){
        this.count = count;
        return this;
    }

    public IngredientBuilder setNameIngredient(String name){
        this.name = name;
        return this;
    }

    public IngredientBuilder setDishName(String dishName){
        this.dishName = dishName;
        return this;
    }

    public Ingredient build(){
        return new Ingredient(id,count,name, dishName);
    }
}

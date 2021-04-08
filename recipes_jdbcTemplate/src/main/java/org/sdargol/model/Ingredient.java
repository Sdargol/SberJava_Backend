package org.sdargol.model;

public class Ingredient {
    private final int id;
    private final int count;
    private final String name;
    private final String dishName;

    public Ingredient(int id, int count, String name, String dishName) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.dishName = dishName;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getDishName() {
        return dishName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", dishName='" + dishName + '\'' +
                '}';
    }
}

package com.sdargol.DTO;

public class DishRequest {
    private String name;

    public DishRequest() {
    }

    public DishRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.sdargol.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DishDTO {
    @Size(min = 3, max = 25, message = "Название должно содержать от 3 до 25 символов")
    private String name;

    @NotNull(message = "Список ингредиентов пуст")
    private List<@Valid IngredientDTO> ingredients;

    public DishDTO() {
    }

    public DishDTO(String name, List<IngredientDTO> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}

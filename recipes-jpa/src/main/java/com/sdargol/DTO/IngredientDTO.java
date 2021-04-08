package com.sdargol.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class IngredientDTO {
    @Size(min = 3, max = 25, message = "Название ингредиента должно содержать от 3 до 25 символов")
    private String name;

    @Min(1)
    @Max(10)
    private Integer count;

    public IngredientDTO() {
    }

    public IngredientDTO(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

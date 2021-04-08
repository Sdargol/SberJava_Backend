package org.sdargol.dao;

import org.sdargol.model.Ingredient;
import org.sdargol.model.IngredientBuilder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
        IngredientBuilder ingredientBuilder = new IngredientBuilder();

        return ingredientBuilder.setId(resultSet.getInt("id"))
                .setNameIngredient(resultSet.getString("name"))
                .setCount(resultSet.getInt("count"))
                .setDishName(resultSet.getString("dish_name"))
                .build();
    }
}

package org.sdargol.dao;

import org.sdargol.model.Dish;
import org.sdargol.model.DishBuilder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishRowMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet resultSet, int i) throws SQLException {
        DishBuilder dishBuilder = new DishBuilder();

        return dishBuilder.setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setIngredients(null)
                .build();
    }
}

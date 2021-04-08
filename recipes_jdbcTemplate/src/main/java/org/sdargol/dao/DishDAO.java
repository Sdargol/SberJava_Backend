package org.sdargol.dao;

import org.sdargol.model.Dish;
import org.sdargol.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DishDAO implements DAO<Dish> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DishDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Dish entity) {
        jdbcTemplate.update("INSERT INTO dishes(name) VALUES(?)", entity.getName());

        jdbcTemplate.batchUpdate(
                "INSERT INTO ingredients(name, count, dish_name) VALUES(?, ?, ?);",
                new BatchPreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1, entity.getIngredients().get(i).getName());
                        preparedStatement.setInt(2, entity.getIngredients().get(i).getCount());
                        preparedStatement.setString(3, entity.getIngredients().get(i).getDishName());
                    }

                    @Override
                    public int getBatchSize() {
                        return entity.getIngredients().size();
                    }
                });
    }

    @Override
    public List<Dish> search(String name) {
        List<Dish> dishes = jdbcTemplate.query("SELECT * FROM dishes WHERE name LIKE ?",
                new Object[]{"%" + name + "%"}, new DishRowMapper());

        List<Ingredient> ingredients = jdbcTemplate.query("SELECT * FROM ingredients WHERE dish_name LIKE ?",
                new Object[]{"%" + name + "%"}, new IngredientRowMapper());

        dishes.forEach(d -> {
            ArrayList<Ingredient> ing = new ArrayList<>();
            ingredients.forEach(i -> {
                if (d.getName().equals(i.getDishName())) {
                    ing.add(i);
                }
            });
            d.setIngredients(ing);
        });

        return dishes;
    }

    @Override
    public Dish searchFullName(String name) {
        List<Dish> dishes = jdbcTemplate.query("SELECT * FROM dishes WHERE name = ?",
                new Object[]{name}, new DishRowMapper());

        List<Ingredient> ingredients = jdbcTemplate.query("SELECT * FROM ingredients WHERE dish_name = ?",
                new Object[]{name}, new IngredientRowMapper());

        Dish dish = dishes.stream()
                .findAny()
                .orElse(null);

        if (dish != null) {
            dish.setIngredients(ingredients);
        }

        return dish;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM dishes WHERE id = ?", id);
    }
}

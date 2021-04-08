package com.sdargol.service;

import com.sdargol.DTO.DishDTO;
import com.sdargol.DTO.DishRequest;
import com.sdargol.DTO.IngredientDTO;
import com.sdargol.entity.DishEntity;
import com.sdargol.entity.IngredientEntity;
import com.sdargol.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<DishEntity> selectAll(){
        return dishRepository.findAll();
    }

    public DishEntity findDish(String name){
        return dishRepository.findByName(name);
    }

    public List<DishEntity> findDish(DishRequest dishRequest){
        return dishRepository.findByNameContaining(dishRequest.getName());
    }

    @Transactional
    public DishEntity deleteDish(String name){
        List<DishEntity> dishes = dishRepository.deleteByName(name);
        return dishes.get(0);
    }

    public DishEntity saveDish(DishDTO dishDTO){
        ArrayList<IngredientEntity> ingredients = new ArrayList<>();

        for(IngredientDTO i : dishDTO.getIngredients()){
            ingredients.add(new IngredientEntity(i.getName(), i.getCount()));
        }

        DishEntity dish = new DishEntity();
        dish.setName(dishDTO.getName());
        dish.setIngredients(ingredients);

        dishRepository.save(dish);

        return dish;
    }

}

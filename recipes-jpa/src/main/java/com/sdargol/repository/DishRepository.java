package com.sdargol.repository;

import com.sdargol.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<DishEntity, Integer> {
    DishEntity findByName(String name);
    List<DishEntity> deleteByName(String name);
    List<DishEntity> findByNameContaining(String name);
}

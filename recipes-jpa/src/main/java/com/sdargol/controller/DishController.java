package com.sdargol.controller;

import com.sdargol.DTO.DishDTO;
import com.sdargol.DTO.DishRequest;
import com.sdargol.DTO.ValidExceptionResponse;
import com.sdargol.entity.DishEntity;
import com.sdargol.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public final class DishController {
    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public ResponseEntity<List<DishEntity>> getAll(){
        return ResponseEntity.ok(dishService.selectAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<DishEntity> getDish(@PathVariable String name){
        DishEntity dish = dishService.findDish(name);
        return ResponseEntity.ok(dish);
    }

    @PostMapping
    public ResponseEntity<DishEntity> saveDish(@Valid @RequestBody DishDTO dishDTO){
        DishEntity dish = dishService.saveDish(dishDTO);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<DishEntity>> searchDish(@RequestBody DishRequest dishRequest){
        List<DishEntity> dishes = dishService.findDish(dishRequest);
        return ResponseEntity.ok(dishes);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<DishEntity> deleteDish(@PathVariable String name){
        DishEntity dish = dishService.deleteDish(name);
        return ResponseEntity.ok(dish);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidExceptionResponse> handleValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ValidExceptionResponse(e.getFieldErrors().get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

}

package org.sdargol.consoleManager;

import org.sdargol.model.Dish;
import org.sdargol.model.DishBuilder;
import org.sdargol.model.Ingredient;
import org.sdargol.model.IngredientBuilder;
import org.sdargol.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleManager {
    private final DAO<Dish> dishDAO;

    @Autowired
    public ConsoleManager(DAO<Dish> dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void mainLoop() {
        Scanner in = new Scanner(System.in);
        String command;

        do {
            System.out.println("Введите название команды:");
            command = in.next();

            switch (command) {
                case "create" -> create();
                case "search" -> search(in);
                case "searchFullName" -> searchFullName();
                case "delete" -> delete(in);
                case "exit" -> System.out.println("До встречи =)");
                default -> System.out.println("Неизвестная команда");
            }
        } while (!command.equals("exit"));
    }

    private void create() {
        Scanner in = new Scanner(System.in);
        List<Ingredient> ingredientList = new ArrayList<>();

        System.out.println("Введите название блюда:");
        String name = in.nextLine();

        String command;
        do {
            System.out.println("Добавить ингредиент(yes) или сохранить(no)? :");
            command = in.next();

            if (command.equals("yes")) {
                addIngredient(ingredientList, in, name);
            }
        } while (!command.equals("no"));

        DishBuilder dishBuilder = new DishBuilder();

        Dish dish = dishBuilder.setId(0)
                .setName(name)
                .setIngredients(ingredientList)
                .build();

        System.out.println("Сохраняем блюдо в бд " + dish);
        dishDAO.create(dish);
    }

    private void addIngredient(List<Ingredient> ingredientList, Scanner in, String dishName) {
        System.out.println("Введите название ингредиента:");
        String name = in.next();
        System.out.println("Введите количество ингредиента:");
        int count = in.nextInt();

        IngredientBuilder ingredientBuilder = new IngredientBuilder();

        Ingredient ingredient = ingredientBuilder.setId(0)
                .setNameIngredient(name)
                .setCount(count)
                .setDishName(dishName)
                .build();

        ingredientList.add(ingredient);
    }

    private void search(Scanner in){
        System.out.println("Введите часть названия блюда :");
        String name = in.next();
        System.out.println(dishDAO.search(name));
    }

    private void searchFullName(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите полное название блюда :");
        String name = in.nextLine();
        System.out.println(dishDAO.searchFullName(name));
    }

    private void delete(Scanner in){
        System.out.println("Введите id блюда, которое надо удалить :");
        int id = in.nextInt();
        dishDAO.delete(id);
    }
}

package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random randomInt = new Random();

    HashMap<String, ArrayList<String>> dishesByTypes;
    ArrayList<String>  searchArrayOfItems;

    /*Конструктор классов для DinnerConstructor*/
    DinnerConstructor() {
        dishesByTypes = new HashMap<>();
        searchArrayOfItems = new ArrayList<>();//Он нужен для осуществления поиска.
    }

    /*Метод, который добавляет блюдо в меню*/
    void addDishToMenu(String dishType, String dishName) {
        if (dishesByTypes.isEmpty() || !(dishesByTypes.containsKey(dishType))) {
            ArrayList menuPositions = new ArrayList();
            menuPositions.add(dishName);
            dishesByTypes.put(dishType, menuPositions);
        } else {
            ArrayList<String> menuPositions = dishesByTypes.get(dishType);
            menuPositions.add(dishName);
            dishesByTypes.put(dishType, menuPositions);
        }
    }

    /*Метод создания комбо. В случае отсутствия категории выводится предупреждение*/
    HashMap<String, ArrayList<String>> createComboMenu(ArrayList<String> searchArrayOfItems) {
        HashMap<String, ArrayList<String>> outputComboOfDishes = new HashMap<>();

        for (String type : searchArrayOfItems) {
            ArrayList<String> randomMenuPositions = dishesByTypes.get(type);
            if (randomMenuPositions != null && !randomMenuPositions.isEmpty()) {
                // Выбираем случайное блюдо из списка
                int randomIndex = randomInt.nextInt(randomMenuPositions.size());
                String randomDish = randomMenuPositions.get(randomIndex);
                // Создаем список с одним выбранным блюдом и добавляем в результат
                ArrayList<String> combo = new ArrayList<>();
                combo.add(randomDish);
                outputComboOfDishes.put(type, combo);
            }
        }
        return outputComboOfDishes;
    }

    /*Метод добавляющий в поисковой массив значения с консоли*/
    ArrayList<String> addItemsToSearchArray(String item) {
        searchArrayOfItems.add(item);
        return searchArrayOfItems;
    }


    /*Метод очистки поискового массива*/
    ArrayList<String> clearItemsToSearchArray() {
        searchArrayOfItems.clear();
        return searchArrayOfItems;
    }



}

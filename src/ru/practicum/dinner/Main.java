package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        /*В соответствие с заданием из главного меню вызываются только метода. Часть оставили нетронутой*/
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDishToMenu(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        /*реализуйте ввод типов блюд*/
        String nextItem = scanner.nextLine();

        /*Наполняем поисковой массив значениям из консоли*/
        while (!nextItem.isEmpty()) {
           if (!(dc.dishesByTypes.containsKey(nextItem))) {
               System.out.println("Введен некорректный тип: " + nextItem + ". Его нет в категориях меню");
           }
           dc.searchArrayOfItems = dc.addItemsToSearchArray(nextItem);
           nextItem = scanner.nextLine();
        }

        /*сгенерируйте комбинации блюд и выведите на экран*/
        for (int combo = 1; combo <= numberOfCombos; combo++) {
            System.out.println("Комбо " + combo);
            HashMap<String, ArrayList<String>> outputComboOfDishes;
            outputComboOfDishes = dc.createComboMenu(dc.searchArrayOfItems);
            System.out.println(outputComboOfDishes);
        }

        /*Очищаем поисковой массив, для того, чтобы он не фонил при последующх вызовах*/
        dc.clearItemsToSearchArray();


    }
}

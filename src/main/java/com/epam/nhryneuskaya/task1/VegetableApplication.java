package com.epam.nhryneuskaya.task1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VegetableApplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Record> records = ReadVegetablesFromFile.reader(scanner);
        Salad salad = new Salad(StringToVegetable.convert(records));
        System.out.println("Calories in salad: " + salad.getCalories() + "Calories");

        System.out.println("Enter sort option: calorie, proteins, fat, carbohydrates, calories, weight");
        String option = scanner.nextLine();
        salad.sort(option);
        System.out.println();

        System.out.println("Enter minimum and maximum calories");
        int minCalories;
        int maxCalories;
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("Wrong minimum/maximum calories");
        } else {
            minCalories = scanner.nextInt();
            maxCalories = scanner.nextInt();
            if (minCalories < 0) {
                throw new IllegalArgumentException("Wrong minimum calories: " + minCalories);
            }
            if (maxCalories < 0 || maxCalories < minCalories) {
                throw new IllegalArgumentException("Wrong maximum calories: " + maxCalories);
            }
        }

        salad.findVegetables(minCalories, maxCalories);
        scanner.close();
    }
}
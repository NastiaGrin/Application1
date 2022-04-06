package com.epam.nhryneuskaya.task1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VegetableApplication {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter way to your file:");
        String filename = scanner.nextLine();

        List<Record> records = FileToRecords.read(filename);
        Salad salad = new Salad(StringToVegetable.convert(records));
        System.out.println("Calories in salad: " + salad.getCalories() + " calories");

        System.out.println("Enter sort option: calorie, calories, carbohydrates, fat, proteins, weight");
        String option = scanner.nextLine();
        salad.sort(option);

        System.out.println("\n Enter minimum and maximum calories:");
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

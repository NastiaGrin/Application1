import vegetables.Vegetable;

import java.util.List;

public class Salad {

    private final List<Vegetable> vegetables;
    private double calories;

    public Salad(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
        this.calories = 0;
        for (Vegetable vegetable : vegetables) {
            this.calories += vegetable.getCalories();
        }
    }

    public void sort(String option) {
        VegetableComparator comparator = new VegetableComparator(option);
        vegetables.sort(comparator);
        for (Vegetable vegetable : vegetables) {
            System.out.print(vegetable.getClass().getSimpleName() +
                    " " + vegetable.getOption(option) + " ");
        }
    }

    public void findVegetables(double minCalories, double maxCalories) {
        int numberOfVegetables = 0;
        for (Vegetable vegetable : vegetables) {
            if (vegetable.getCalories() > minCalories && vegetable.getCalories() < maxCalories) {
                System.out.print(vegetable.getClass().getSimpleName() +
                        " " + vegetable.getCalories() + " ");
                numberOfVegetables++;
            }
        }
        if (numberOfVegetables == 0) {
            System.out.println("There is not any vegetables with such calories.");
        }
    }

    public double getCalories() {
        return calories;
    }
}

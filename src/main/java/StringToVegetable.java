import vegetables.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringToVegetable {

    public static List<Vegetable> change(List<Double> weights, List<String> names, Scanner scanner) {
        List<Vegetable> vegetables = new ArrayList<>();
        boolean sameVegetable;
        for (int i = 0; i < weights.size(); i++) {
            switch (names.get(i).toLowerCase()) {
                case "potato": {
                    sameVegetable = false;
                    for (Vegetable vegetable : vegetables) {
                        if (vegetable instanceof Potato) {
                            vegetable.setWeight(vegetable.getWeight() + weights.get(i));
                            sameVegetable = true;
                            break;
                        }
                    }
                    if (!sameVegetable) {
                        vegetables.add(new Potato(weights.get(i)));
                    }
                    break;
                }
                case "tomato": {
                    sameVegetable = false;
                    for (Vegetable vegetable : vegetables) {
                        if (vegetable instanceof Tomato) {
                            vegetable.setWeight(vegetable.getWeight() + weights.get(i));
                            sameVegetable = true;
                        }
                    }
                    if (!sameVegetable) {
                        vegetables.add(new Tomato(weights.get(i)));
                    }
                    break;
                }
                case "lettuce": {
                    sameVegetable = false;
                    for (Vegetable vegetable : vegetables) {
                        if (vegetable instanceof Lettuce) {
                            vegetable.setWeight(vegetable.getWeight() + weights.get(i));
                            sameVegetable = true;
                            break;
                        }
                    }
                    if (!sameVegetable) {
                        vegetables.add(new Lettuce(weights.get(i)));
                    }
                    break;
                }
                case "pepper": {
                    sameVegetable = false;
                    for (Vegetable vegetable : vegetables) {
                        if (vegetable instanceof Pepper) {
                            vegetable.setWeight(vegetable.getWeight() + weights.get(i));
                            sameVegetable = true;
                            break;
                        }
                    }
                    if (!sameVegetable) {
                        vegetables.add(new Pepper(weights.get(i)));
                    }
                    break;
                }
                case "cucumber": {
                    sameVegetable = false;
                    for (Vegetable vegetable : vegetables) {
                        if (vegetable instanceof Cucumber) {
                            vegetable.setWeight(vegetable.getWeight() + weights.get(i));
                            sameVegetable = true;
                            break;
                        }
                    }
                    if (!sameVegetable) {
                        vegetables.add(new Cucumber(weights.get(i)));
                    }
                    break;
                }
                default: {
                    System.out.println("Wrong data. Try again.");
                    ReadVegetablesFromFile.reader(names, weights, scanner);
                    break;
                }
            }
        }
        return vegetables;
    }
}
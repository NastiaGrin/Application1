import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VegetableApplication {
    public static void main(String[] args) {

        int minCalories = 0;
        int maxCalories = 0;
        String option;
        Salad salad;
        List <Record> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ReadVegetablesFromFile.reader(records, scanner);
        salad = new Salad(StringToVegetable.change(records));
        System.out.println("Calories in salad: " + salad.getCalories() + "Calories");

        System.out.println("Enter sort option: calorie, proteins, fat, carbohydrates, calories, weight");
        try {
            option = scanner.nextLine();
            salad.sort(option);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong option.");
            System.exit(4);
        }
        System.out.println();

        System.out.println("Enter min and max calories.");
        try {
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Wrong min/max value.");
            } else {
                minCalories = scanner.nextInt();
                maxCalories = scanner.nextInt();
                if ((maxCalories < minCalories) || (maxCalories < 0 || minCalories < 0)) {
                    throw new IllegalArgumentException("Wrong min/max value.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong min/max value.");
            System.exit(5);
        }
        salad.findVegetables(minCalories, maxCalories);
        scanner.close();
    }
}
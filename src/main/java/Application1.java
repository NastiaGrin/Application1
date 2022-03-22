 /*
  * Nastassia Hryneuskaya
  */

 import java.lang.invoke.WrongMethodTypeException;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;

 public class Application1 {
     public static void main(String[] args) {

         int minCalories;
         int maxCalories;
         String option;
         Salad salad;
         List<String> names = new ArrayList<>();
         List<Double> weights = new ArrayList<>();
         Scanner scanner = new Scanner(System.in);

         ReadVegetablesFromFile.reader(names, weights, scanner);
         salad = new Salad(StringToVegetable.change(weights, names, scanner));
         System.out.println("Calories in salad: " + salad.getCalories() + "Calories");

         while (true) {
             System.out.println("Enter sort option: calorie, proteins, fat, carbohydrates, calories, weight");
             try {
                 option = scanner.nextLine();
                 salad.sort(option);
                 break;
             } catch (WrongMethodTypeException e) {
                 System.out.println("Wrong option.");
             }
         }
         System.out.println();

         while (true) {
             System.out.println("Enter min and max calories.");
             try {
                 if (!scanner.hasNextInt()) {
                     throw new IllegalArgumentException("Wrong min/max value.");
                 } else {
                     minCalories = scanner.nextInt();
                     maxCalories = scanner.nextInt();
                     if ((maxCalories < minCalories) || (maxCalories < 0 || minCalories < 0)) {
                         throw new IllegalArgumentException("Wrong min/max value.");
                     } else break;
                 }
             } catch (IllegalArgumentException e) {
                 System.out.println("Wrong min/max value. Try again.");
                 scanner.nextLine();
             }
         }
         salad.findVegetables(minCalories, maxCalories);
         scanner.close();
     }
 }
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadVegetablesFromFile {
    public static void reader(List<String> names, List<Double> weights, Scanner scanner) {

        String filename;
        Reader reader;
        BufferedReader buffReader;
        String data;
        names.clear();
        weights.clear();

        System.out.println("Create txt file with name of vegetable and it weight. Split it with space. " +
                "You can chose tomato, potato, lettuce, pepper, cucumber.");
        start:
        while (true) {
            System.out.println("Enter way to your file.");
            filename = scanner.nextLine();

            try {
                reader = new FileReader(filename);
                buffReader = new BufferedReader(reader);

                while ((data = buffReader.readLine()) != null) {
                        try {
                            if (Double.parseDouble(data.split(" ")[1]) <= 0) {
                                throw new NumberFormatException();
                            }
                            names.add(data.split(" ")[0]);
                            weights.add(Double.parseDouble(data.split(" ")[1]));
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong string.");
                            break start;
                        }
                    }
                buffReader.close();
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not founded.");
            } catch (IOException e) {
                System.out.println("Error in-output.");
            }

        }
    }
}

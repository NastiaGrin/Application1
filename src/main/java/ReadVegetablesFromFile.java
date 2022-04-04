import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadVegetablesFromFile {
    public static void reader(List<Record> records, Scanner scanner) {

        String filename;
        Reader reader;
        BufferedReader buffReader;
        String data;
        records.clear();

        System.out.println("Create txt file with name of vegetable and it weight. Split it with space. " +
                "You can chose tomato, potato, lettuce, pepper, cucumber.");

        System.out.println("Enter way to your file.");
        filename = scanner.nextLine();

        try {
            reader = new FileReader(filename);
            buffReader = new BufferedReader(reader);

            while ((data = buffReader.readLine()) != null) {
                try {
                    if (Double.parseDouble(data.split(" ")[1]) <= 0) {
                        throw new IllegalArgumentException("Wrong weight of " + data.split(" ")[0]);
                    }
                    records.add(new Record(Double.parseDouble(data.split(" ")[1]), data.split(" ")[0]));
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong weight.");
                    System.exit(1);
                }
            }
            buffReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not founded.");
            System.exit(2);
        } catch (IOException e) {
            System.out.println("Error in-output.");
            System.exit(3);
        }

    }
}

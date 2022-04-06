package com.epam.nhryneuskaya.task1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadVegetablesFromFile {
    public static List<Record> reader(Scanner scanner) throws IOException {
        System.out.println("Create txt file with name of vegetable and it weight. " +
                "Split it with space. " +
                "You can chose cucumber, lettuce, pepper, potato, tomato.");

        System.out.println("Enter way to your file.");
        String filename = scanner.nextLine();

        List<Record> records = new ArrayList<>();

        try (InputStream is = ReadVegetablesFromFile.class.getClassLoader().getResourceAsStream(filename);
             Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(r)) {

            String line;
            while ((line = br.readLine()) != null) {
                String part1 = line.split(" ")[0];
                String part2 = line.split(" ")[1];

                double weight = Double.parseDouble(part2);
                if (weight <= 0) {
                    throw new IllegalArgumentException("Wrong weight in the line: " + line);
                }

                records.add(new Record(part1, weight));
            }
        }

        return records;
    }
}


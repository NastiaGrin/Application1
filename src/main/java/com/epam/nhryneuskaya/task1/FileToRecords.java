package com.epam.nhryneuskaya.task1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class FileToRecords {

    private FileToRecords() {
    }

    public static List<Record> read(String filename) throws IOException {
        System.out.println("Create txt file with name of vegetable and it weight. " +
                "Split it with space. " +
                "You can chose cucumber, lettuce, pepper, potato, tomato.");

        List<Record> records = new ArrayList<>();

        try (InputStream is = FileToRecords.class.getClassLoader().getResourceAsStream(filename);
             Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(r)) {

            String line;
            while ((line = br.readLine()) != null) {
                String name = line.split(" ")[0];
                double weight = Double.parseDouble(line.split(" ")[1]);

                if (weight <= 0) {
                    throw new IllegalArgumentException("Wrong weight in the line: " + line);
                }

                records.add(new Record(name, weight));
            }
        }

        return records;
    }
}

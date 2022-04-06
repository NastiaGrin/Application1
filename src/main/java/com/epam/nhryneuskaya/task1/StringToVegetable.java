package com.epam.nhryneuskaya.task1;

import com.epam.nhryneuskaya.task1.vegetables.*;

import java.util.ArrayList;
import java.util.List;

public final class StringToVegetable {

    private StringToVegetable() {
    }

    public static List<Vegetable> convert(List<Record> records) {
        List<Vegetable> vegetables = new ArrayList<>(records.size());

        for (Record record : records) {
            Vegetable vegetable;
            switch (record.getName()) {
                case "cucumber": {
                    vegetable = new Cucumber(record.getWeight());
                    break;
                }
                case "lettuce": {
                    vegetable = new Lettuce(record.getWeight());
                    break;
                }
                case "pepper": {
                    vegetable = new Pepper(record.getWeight());
                    break;
                }
                case "potato": {
                    vegetable = new Potato(record.getWeight());
                    break;
                }
                case "tomato": {
                    vegetable = new Tomato(record.getWeight());
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown vegetable: " + record.getName());
            }
            vegetables.add(vegetable);
        }

        return vegetables;
    }
}

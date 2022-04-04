import vegetables.*;

import java.util.ArrayList;
import java.util.List;

public class StringToVegetable {

    public static List<Vegetable> change(List<Record> records) {
        List<Vegetable> vegetables = new ArrayList<>(records.size());
        for (Record record : records) {
            Vegetable vegetable;
            switch (record.getName()) {
                case "potato": {
                    vegetable = new Potato(record.getWeight());
                    break;
                }
                case "tomato": {
                    vegetable = new Tomato(record.getWeight());
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
                case "cucumber": {
                    vegetable = new Cucumber(record.getWeight());
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
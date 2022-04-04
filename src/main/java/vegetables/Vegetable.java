package vegetables;

public abstract class Vegetable {

    protected String name;
    private final double calorie;
    private final double proteins;
    private final double fat;
    private final double carbohydrates;
    private final double calories;

    private double weight;

    public Vegetable(double calorie, double proteins, double weight, double fat, double carbohydrates) {
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.calorie = calorie;
        this.weight = weight;
        this.proteins = proteins;
        this.calories = weight * calorie / 100;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public double getCalorie() {
        return calorie;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public Double getOption(String option) {
        switch (option.toLowerCase()) {
            case "calories": {
                return calories;
            }
            case "proteins": {
                return proteins;
            }
            case "carbohydrates": {
                return carbohydrates;
            }
            case "calorie": {
                return calorie;
            }
            case "fat": {
                return fat;
            }
            case "weight": {
                return weight;
            }
        }
        throw new IllegalArgumentException("Wrong option: " + option);
    }
}
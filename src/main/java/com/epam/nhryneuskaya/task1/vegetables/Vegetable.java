package com.epam.nhryneuskaya.task1.vegetables;

public abstract class Vegetable {

    private final String name;
    private final double calorie;
    private final double calories;
    private final double carbohydrates;
    private final double fat;
    private final double proteins;
    private final double weight;


    public Vegetable(String name, double calorie, double carbohydrates, double fat, double proteins, double weight) {
        this.name = name;
        this.calorie = calorie;
        this.calories = weight * calorie / 100;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.proteins = proteins;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getCalorie() {
        return calorie;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public double getProteins() {
        return proteins;
    }

    public double getWeight() {
        return weight;
    }

    public Double getOption(String option) {
        switch (option.toLowerCase()) {
            case "calorie": {
                return calorie;
            }
            case "calories": {
                return calories;
            }
            case "carbohydrates": {
                return carbohydrates;
            }
            case "fat": {
                return fat;
            }
            case "proteins": {
                return proteins;
            }
            case "weight": {
                return weight;
            }
            default: {
                throw new IllegalArgumentException("Wrong option: " + option);
            }
        }
    }
}

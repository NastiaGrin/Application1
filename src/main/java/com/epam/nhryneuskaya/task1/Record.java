package com.epam.nhryneuskaya.task1;

public class Record {

    private final String name;
    private final double weight;

    public Record(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}

package com.epam.nhryneuskaya.task1;

import com.epam.nhryneuskaya.task1.vegetables.Vegetable;

import java.util.Comparator;

public class VegetableComparator implements Comparator<Vegetable> {

    private final String option;

    public VegetableComparator(String option) {
        this.option = option;
    }

    @Override
    public int compare(Vegetable vegetable1, Vegetable vegetable2) {
        return vegetable1.getOption(option).compareTo(vegetable2.getOption(option));
    }
}

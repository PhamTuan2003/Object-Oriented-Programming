package com.vn.viettel.digital.lambda.model;

import java.time.LocalDate;
import java.time.Period;

public class Girl {
    private String name;
    private LocalDate birthday;
    private Float height;
    private Float weight;
    

    public Girl() {
    }

    public Girl(String name, LocalDate birthday, Float height, Float weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Height: " + height + " | Weight: " + weight;
    }
}

package com.company.Cars;

import com.company.Car;

public class Truck extends Car {
    private int capacity;

    public Truck(String colour, int speed, String country, int power, int number, int capacity) {
        super(colour, speed, country, power, number);
        this.capacity = capacity;
    }
    public int getCapacity(){return capacity;}
    public String information(){
        String fullInf = super.information();
        fullInf += "\nCapacity:" + getCapacity();
        return fullInf;
    }
}

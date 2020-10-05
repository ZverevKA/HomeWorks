package com.company.Cars;

import com.company.Car;

public class Bus extends Car {
    private int numberOfPeople;

    public Bus(String colour, int speed, String country, int power, int number, int numberOfPeople) {
        super(colour, speed, country, power, number);
        this.numberOfPeople = numberOfPeople;
    }
    public int getNumberOfPeople(){return numberOfPeople;}
    public String information(){
        String fullInf = super.information();
        fullInf += "\nNumber of people:" + getNumberOfPeople();
        return fullInf;
    }
}


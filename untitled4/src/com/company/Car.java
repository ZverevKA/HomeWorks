package com.company;

public abstract class Car {
    private int number;
    private String colour;
    private int speed;
    private String country;
    private int power;

    public Car(String colour, int speed, String country, int power, int number) {
        this.number = number;
        this.colour = colour;
        this.speed = speed;
        this.country = country;
        this.power = power;
    }

    public String getColour() {
        return colour;
    }

    public int getSpeed() {
        return speed;
    }

    public String getCountry() {
        return country;
    }

    public int getPower() {
        return power;
    }

    public int getNumber() {
        return number;
    }

    public String information() {
        String fullInf = "Number:" + getNumber() + "\nMax speed:" + getSpeed() + "\nCountry:" + getCountry() + "\nPower:" + getPower();
        return fullInf;
    }
}



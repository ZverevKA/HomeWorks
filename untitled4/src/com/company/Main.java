package com.company;

import com.company.Cars.Bus;
import com.company.Cars.Truck;

public class Main {

    public static void main(String[] args) {
        Bus tb = new Bus("WHITE", 100, "RUSSIA", 170, 541239, 14);
        Truck tt = new Truck("GREY", 140, "BRITAN", 210, 115789, 3000);
        System.out.println(tb.information());
        System.out.println(tt.information());
    }
}

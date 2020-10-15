package com.company.Tests;
import static org.junit.Assert.*;
import com.company.Car;
import com.company.Cars.Bus;
import com.company.Cars.Truck;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private Car carBus;
    private Car carTruck;

    @Before
    public void setUp() throws Exception{
        carBus = new Bus("GREEN", 140, "GERMANY", 192, 152876, 10);
        carTruck = new Truck("BLACK", 120, "RUSSIA", 220, 547831, 1500);
    }

    @Test
    public void getterColourTest(){
        assertEquals("GREEN", carBus.getColour());
        assertEquals("BLACK", carTruck.getColour());
    }

    @Test
    public void getterSpeedTest(){
        assertEquals(140, carBus.getSpeed());
        assertEquals(120, carTruck.getSpeed());
    }

    @Test
    public void getterCountryTest(){
        assertEquals("GERMANY", carBus.getCountry());
        assertEquals("RUSSIA", carTruck.getCountry());
    }

    @Test
    public void getterPowerTest(){
        assertEquals(192, carBus.getPower());
        assertEquals(220, carTruck.getPower());
    }

    @Test
    public void getterNumberTest(){
        assertEquals(152876, carBus.getNumber());
        assertEquals(547831, carTruck.getNumber());
    }
}


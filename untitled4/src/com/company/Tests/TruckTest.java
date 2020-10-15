package com.company.Tests;

import com.company.Cars.Truck;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TruckTest {
    private Truck truck;

    @Before
    public void setUp() throws Exception{
        truck = new Truck("BLACK", 120, "RUSSIA", 220, 547831, 1500);
    }
    @Test
    public void getterNumberOfPeopleTest(){
        assertEquals(1500, truck.getCapacity());
    }
    @Test
    public void informationTest(){
        assertEquals("Number:547831\nMax speed:120\nCountry:RUSSIA\nPower:220\nCapacity:1500", truck.information());
    }
}


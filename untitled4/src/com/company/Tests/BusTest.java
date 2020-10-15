package com.company.Tests;

import static org.junit.Assert.*;
import com.company.Cars.Bus;
import org.junit.Before;
import org.junit.Test;

public class BusTest {
    private Bus bus;

    @Before
    public void setUp() throws Exception{
        bus = new Bus("GREEN", 140, "GERMANY", 192, 152876,10);
    }
    @Test
    public void getterNumberOfPeopleTest(){
        assertEquals(10, bus.getNumberOfPeople());
    }
    @Test
    public void informationTest(){
        assertEquals("Number:152876\nMax speed:140\nCountry:GERMANY\nPower:192\nNumber of people:10", bus.information());
    }

}

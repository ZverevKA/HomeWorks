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
}

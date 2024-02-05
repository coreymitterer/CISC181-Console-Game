package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CaseTest {
    @Test
    public void testingCaseClass(){
        System.out.println("Testing Case class");
        Case c1 = new Case("Sam", "Blue");
        assertEquals("Sam", c1.getOwnerName());
        assertEquals("Blue", c1.getColor());
        assertEquals(c1.toString(),"Case Owner : Sam , Color : Blue");
    }

}

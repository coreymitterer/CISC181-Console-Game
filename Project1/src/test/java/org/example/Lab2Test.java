package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab2Test {
    @Test
    public void roll() {
        assertEquals(0,Lab2.roll(new Random(),1,1));
        //This test will not pass 100% of the time due to the fact that its impossible to predict the random output of the number
        // assertEquals(5,Lab1.roll(new Random(),1,5));

    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayStaticMethodsTest {
    @Test
    public void testSumSqrPos() {
        System.out.println("Testing sumSqrPos");
        assertEquals(0, ArrayStaticMethods.sumSqrPos(new double[]{-1.9, -2.5, -3.7, -2, -1, -6, -3, -4, -5, -2}), 0.01);
        assertEquals(42.08, ArrayStaticMethods.sumSqrPos(new double[]{1.9, -2.5, 3.7, -2, 1, -6, -3, 4.3, -5, 2.3}), 0.01);
        assertEquals(2, ArrayStaticMethods.sumSqrPos(new double[]{1.414}), 0.01);
        assertEquals(0, ArrayStaticMethods.sumSqrPos(new double[]{0,-1}), 0.01);
        //add a test with negative numbers

    }

    @Test
    public void testCountChars() {
        System.out.println("Testing countChars");
        assertEquals(4, ArrayStaticMethods.countChars("The quick brown fox leaps over the lazy dog.".toCharArray(), 'e'));
        assertEquals(6, ArrayStaticMethods.countChars("My mother comes home from Alabama tomorrow".toCharArray(), 'm'));
        assertEquals(3, ArrayStaticMethods.countChars("Can't wait for spring break!".toCharArray(), 'a'));
        assertEquals(1, ArrayStaticMethods.countChars("Can't wait for spring break!".toCharArray(), 'C'));


    }

    @Test
    public void testReplace() {
        System.out.println("Testing replace");
        assertArrayEquals(new int[]{1, 6, 6, 1}, ArrayStaticMethods.replace(new int[]{1, 0, 0, 1}, 0, 6));
        assertArrayEquals(new int[]{5, 5, 5, 5}, ArrayStaticMethods.replace(new int[]{5, 0, 0, 5}, 0, 5));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.replace(new int[]{}, 0, 5));
        assertArrayEquals(new int[]{1,1,1,1,1}, ArrayStaticMethods.replace(new int[]{1,1,1,1,1}, 0, 6));
        // add a test where no replacements occur

    }

   @Test
    public void testMoveNegatives() {
        System.out.println("Testing moveNegatives");
        assertArrayEquals(new int[]{1, 0, 0, 1}, ArrayStaticMethods.moveNegatives(new int[]{1, 0, 0, 1}));
        assertArrayEquals(new int[]{-1, -5, -7, 1, 3, 0}, ArrayStaticMethods.moveNegatives(new int[]{-1, 1, -5, 3, 0, -7}));
        assertArrayEquals(new int[]{1}, ArrayStaticMethods.moveNegatives(new int[]{1}));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.moveNegatives(new int[]{}));
       assertArrayEquals(new int[]{-7,-2,8}, ArrayStaticMethods.moveNegatives(new int[]{8,-7,-2}));
       assertArrayEquals(new int[]{-7,-2,8,9}, ArrayStaticMethods.moveNegatives(new int[]{8,9,-7,-2}));
    }


}


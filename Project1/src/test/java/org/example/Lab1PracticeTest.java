package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class Lab1PracticeTest {

    @Test
    public void areaScalene() {
        System.out.println("Testing area Scalene");
        assertEquals(3.96,Lab1Practice.areaScalene(5.5,3.4,8.7),0.0001);
        assertEquals(6.49519052838329,Lab1Practice.areaScalene(5,3.0,7.0),0.0001);
        assertEquals(11.976539567003485,Lab1Practice.areaScalene(6,7,4),0.0001);
    }
    @Test
    public void okCourses(){
        System.out.println("Testing okCourses");
        assertFalse(Lab1Practice.okCourses(14,1));
        assertFalse(Lab1Practice.okCourses(11,4));
        assertFalse(Lab1Practice.okCourses(20,4));
        assertFalse(Lab1Practice.okCourses(15,0));
        assertEquals(true,Lab1Practice.okCourses(15, 1));
        assertEquals(true,Lab1Practice.okCourses(14, 2));
    }

}
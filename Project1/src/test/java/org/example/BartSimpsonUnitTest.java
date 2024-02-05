/*package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class BartSimpsonUnitTest {
    @Test
    public void testingBartSimpsonNoParaemterConstructor() { // Tests for No Parameter Constructor
        System.out.println("Creating Bart Simpson with 0 parameter constructor");
        BartSimpsonUnit B = new BartSimpsonUnit();
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        assertEquals('B', B.getSymbol());
        System.out.println("-- Testing Name");
        assertEquals("Bart Simpson", B.getName());
        System.out.println("-- Testing Health");
        assertEquals(100.0, B.getHealth(), 0.0001);
        System.out.println("-- Testing TimesSpawned");
        assertEquals(0, B.getNumTimesSpawned(), 0.0001);
        System.out.println("-- Testing Disract");
        assertTrue(B.canDistract());
        System.out.println("--Testing canDistract");
        assertTrue(B.canRecruit());

    }

    @Test
    public void testingBartSimpsonParameterConstructor() { // Tests 14 parameters that are not 0 values
        System.out.println("Creating Bart Simpson with 14 parameter constructor");
        BartSimpsonUnit b = new BartSimpsonUnit('b', "bart Simpson", 100.0, 5.0,
                25.0, 10.0, 1, 1, 1, 1, 1, 0, true, true);
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("--Testing Health Modifier");
        assertEquals(5.0, b.getHealthModifier(), 0.0001);
        System.out.println("--Testing Damage");
        assertEquals(25.0, b.getDamage(), 0.0001);
        System.out.println("--Testing damageModifier");
        assertEquals(10.0, b.getDamageModifier(), 0.0001);
        System.out.print("--Testing getLuck");
        assertEquals(1, b.getLuck(), 0.0001);
        System.out.println("-- Testing xCor");
        assertEquals(1, b.getxCor(), 0.0001);
        System.out.println("--Testing yCor");
        assertEquals(1, b.getyCor(), 0.0001);
        System.out.println("-- Movement");
        assertEquals(1, b.getMovement(), 0.0001);
        System.out.println("--Testing movementModifier");
        assertEquals(1, b.getMovementModifier(), 0.0001);
        System.out.println("--Testing distract");
        b.setDistract(true);
        assertTrue(b.canDistract());
        System.out.println("--Testing Recruit");
        b.setRecruit(true);
        assertTrue(b.canRecruit());

    }
    @Test
    public void testingnewBartSimpsonParameterConstructor() { // Tests 14 parameters that are not 0 values
        System.out.println("Creating Bart Simpson with 14 parameter constructor");
        BartSimpsonUnit b = new BartSimpsonUnit('b', "bart Simpson", 100.0, 5.0,
                25.0, 10.0, 0, 1, 1, 1, 1, 0, true, true);
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("--Testing Health Modifier");
        assertEquals(5.0, b.getHealthModifier(), 0.0001);
        System.out.println("--Testing Damage");
        assertEquals(25.0, b.getDamage(), 0.0001);
        System.out.println("--Testing damageModifier");
        assertEquals(10.0, b.getDamageModifier(), 0.0001);
        System.out.print("--Testing getLuck");
        assertEquals(0, b.getLuck(), 0.0001);
        System.out.println("-- Testing xCor");
        assertEquals(1, b.getxCor(), 0.0001);
        System.out.println("--Testing yCor");
        assertEquals(1, b.getyCor(), 0.0001);
        System.out.println("-- Movement");
        assertEquals(1, b.getMovement(), 0.0001);
        System.out.println("--Testing movementModifier");
        assertEquals(1, b.getMovementModifier(), 0.0001);
        System.out.println("--Testing distract");
        b.setDistract(true);
        assertTrue(b.canDistract());
        System.out.println("--Testing Recruit");
        b.setRecruit(true);
        assertTrue(b.canRecruit());

    }
    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
       BartSimpsonUnit B = new BartSimpsonUnit();
        // bart should be able to spawn
        //B.canSpawn(true);
        //assertTrue(B.canSpawn());

        // bart spawns
        BartSimpsonUnit lilBart = B.spawn();
        // Number of times piece has spawned should be increased  assertEquals(1, bart.getNumTimesSpawned());
// Now that max time number of spawns reached - it
// shouldn't be able to spawn anymore
        assertFalse(B.canSpawn());

    }

} */




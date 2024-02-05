package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerTest {
        @Test
        public void testConstructorWithAllFields() {
            System.out.println("Testing Constructor with all valid fields");
            int playerNumber = 1;
            boolean turn = true;
            TomJerryUnit unit = null;
            TomJerryUnit TomJerryUnit = unit;
            unit = TomJerryUnit;
            Player player = new Player(playerNumber, turn, unit);
            assertEquals(playerNumber, player.getPlayerNumber());
            assertEquals(turn, player.getTurn());
            assertEquals(unit, player.getUnit());
        }

       @Test
        public void testConstructorWithoutTurn() {
            System.out.println("Testing Constrcutor without turn ");
            int playerNumber = 2;
            TomJerryUnit unit = null;
            Player player = new Player(playerNumber, unit);
            assertEquals(playerNumber, player.getPlayerNumber());
            assertFalse(player.getTurn());
            assertEquals(unit, player.getUnit());
        }

        @Test
        public void testDefaultConstructor() {
            System.out.println("Test with all Defaults values");
            Player player = new Player();
            assertEquals(1, player.getPlayerNumber());
            assertFalse(player.getTurn());
            assertNull(player.getUnit());
        }

        @Test
        public void testSetters() {
            System.out.println("Testing all the setters");
            Player player = new Player();
            player.setPlayerNumber(3);
            player.setTurn(true);
            TomJerryUnit TomJerryUnit = null;
            player.setUnit(TomJerryUnit);
            assertEquals(3, player.getPlayerNumber());
            assertTrue(player.getTurn());
            assertEquals(TomJerryUnit, player.getUnit());
        }
    }


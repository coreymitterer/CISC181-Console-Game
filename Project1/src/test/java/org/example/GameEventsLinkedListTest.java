/*package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


public class GameEventsLinkedListTest {
    @Test
    public void isEmpty() {
        System.out.println("Testing isEmpty");
        GameEventsLinkedList list = new GameEventsLinkedList();
        assertTrue(list.isEmpty());
    }
    @Test
    public void add (){
        System.out.println("Testing add");
        GameEventsLinkedList list = new GameEventsLinkedList();
        GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(new GameEventNode(1, "Move", "Bart Simpson moved"), null);
        list.add(node);
        assertEquals(1, list.size);

    }
    @Test
    public void remove(){
        System.out.println("Testing remove");
        GameEventsLinkedList list = new GameEventsLinkedList();
        assertNull(list.remove(null));
        assertNull(list.remove(new GameEventsLinkedList.GameEventNode(new GameEvent(1, "Moved", "Bart Simpson moved"), null)));
    }
} */

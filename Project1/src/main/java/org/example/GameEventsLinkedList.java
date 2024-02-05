package org.example;

public class GameEventsLinkedList {
    public GameEventNode head; // represents the first game event
    public int size; // stores the size of the Linked List

    // constructor that sets head to 'null' and size to '0'
    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void push(GameEventNode eventNode) {
        if (head == null) {
            head = eventNode;
        } else {
            eventNode.setNext(head);
            head = eventNode;
            // GameEventNode current = head;
            // while (current.getNext() != null) {
            // current = current.getNext();
            // }
            // current.setNext(eventNode);
            // }
            size++;
        }
    }

    public GameEvent pop(/* GameEventNode eventNode */) {
        if (head == null) {
            return null;
        }
        GameEvent removedEvent = head.getGameState();
        head = head.getNext();
        size--;
        return removedEvent;
        // GameEvent removedEvent = null;
        // if (head == null) {
        // return null;
        // } else if (head == eventNode) {
        // removedEvent = head.getGameState();
        // head = head.getNext();
        // size--;
        // return removedEvent;
        // } else {
        // GameEventNode current = head;
        // while (current.getNext() != null) {
        // if (current.getNext() == eventNode) {
        // removedEvent = current.getNext().getGameState();
        // current.setNext(current.getNext().getNext());
        // size--;
        // break;
        // }
        // current = current.getNext();
        // }

    }

    // Overloaded pop() method
    public GameEventsLinkedList pop(String eventType) {
        GameEventsLinkedList extractList = new GameEventsLinkedList();
        GameEventNode current = head;
        while (current != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                extractList.push(current);
                size--;
            }
            current = current.getNext();
        }
        extractList.size += 1;
        return extractList;
    }

    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    static class GameEvent {
        private int playerNumber; // stores unique identifier for a player
        private String eventType; // acts as a tag for different event categories
        private String eventDetails; // represents a description of the game event

        // constructor that accepts and sets the above fields
        public GameEvent(int playerNumber, String eventType, String eventDetails) {
            this.playerNumber = playerNumber;
            this.eventType = eventType;
            this.eventDetails = eventDetails;
        }

        // getters and setters
        public int getPlayerNumber() {
            return playerNumber;
        }

        public void setPlayerNumber(int playerNumber) {
            this.playerNumber = playerNumber;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEventDetails() {
            return eventDetails;
        }

        public void setEventDetails(String eventDetails) {
            this.eventDetails = eventDetails;
        }
    }

    static class GameEventNode {
        private GameEvent gameState; // stores a specific game event
        private GameEventNode next; // stores the next game event node

        // constructor that accepts a gameState and sets the above properties
        public GameEventNode(GameEvent gameState, GameEventNode next) {
            this.gameState = gameState;
            this.next = null;
        }

        // getters and setters

        public GameEvent getGameState() {
            return gameState;
        }

        public void setGameState(GameEvent gameState) {
            this.gameState = gameState;
        }

        public GameEventNode getNext() {
            return next;
        }

        public void setNext(GameEventNode next) {
            this.next = next;
        }
    }
}

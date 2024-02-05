package org.example;

import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private boolean turn;
    private Team team;

    //Constructor
    public Player(int playerNumber, boolean turn, Team team){
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
    }
    public Player(int playerNumber, Team team) {
        this.playerNumber = playerNumber;
        this.team = team;
        this.turn = false;
    }
    public Player() {
        this.playerNumber = 1;
        this.turn = true;
        this.team = new Team("Unknown", new ArrayList<Unit>());
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Team getTeam() {
        return team;
    }

    public void setPlayersTeam(Team team) {
        this.team = team;
    }
}








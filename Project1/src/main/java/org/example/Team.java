package org.example;

import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Unit> units;
    // two parameter constructor
    public Team(String teamColor, ArrayList<Unit> units){
        this.teamColor = teamColor;
        this.units = units;
    }
    // accessor methods
    public String getTeamColor(){
        return teamColor;
    }
    public ArrayList<Unit> getTeamUnits(){
        return units;
    }
    // mutator methods
    public void removeUnitsFromTeam(Unit unitToRemove){
         units.remove(unitToRemove);
    }
    public void addUnitsToTeam(Unit unitToAdd){
        unitToAdd.setTeamColor(teamColor);
        units.add(unitToAdd);
    }

    // toString methods
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Team ").append(teamColor).append(" Units : ");
        for (Unit unit : units) {
            stringBuilder.append("\n").append(unit.toString());
        }
        return stringBuilder.toString();
    }
}

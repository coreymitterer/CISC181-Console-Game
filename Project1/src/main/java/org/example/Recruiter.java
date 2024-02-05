package org.example;

public abstract class Recruiter extends Unit {
    private int numRecruits;

    public Recruiter(char symbol, String name, double health, double healthModifier,
                     double damage, double damageModifier,
                     int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits) {
        super(symbol, name, health, healthModifier,
                damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.numRecruits = numRecruits;
    }

    public int getNumRecruits() {
        return numRecruits;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }
    /*
    Params: Integers: (first two) represent the row index and column index of the board square that contains the unit recruiting
                      (second two) represent the row index and column index of the unit being recruited.
    Returns: Boolean: represents whether if the recruiter can recruit on that square
    */

    public abstract boolean validRecruitPath(int rowRecruiter, int colRecruiter, int rowRecruit, int colRecruit);
}

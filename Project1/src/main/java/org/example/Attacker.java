package org.example;

public abstract class Attacker extends Unit{
    private int numAttacks;
    
    public Attacker(char symbol, String name, double health, double healthModifier,
                    double damage, double damageModifier,
                    int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks){
        super(symbol, name, health, healthModifier,
                damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.numAttacks = numAttacks;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    /*
    Params: Integers: (first two) represent the row index and column index of the board square that contains the unit attacking
                      (second two) represent the row index and column index of the unit being attacked.
    Returns: Boolean: represents whether if the attacker can attack on that square
    */
    public abstract boolean validAttackPath(int rowAttacker, int colAttacker, int rowAttacked, int colAttacked);
}

package org.example;

public abstract class Unit {
    protected String teamColor;
    protected char symbol;
    protected String name;
    protected double health;
    protected double healthModifier;
    protected double damage;
    protected double damageModifier;
    protected int luck;
    protected int xCor;
    protected int yCor;
    protected int movement;
    protected int movementModifier;
/*
Default Constructor
Parameters: None
 */
    public Unit() {
        this.symbol = ' ';
        this.name = "";
        this.health = 0.0;
        this.healthModifier = 0.0;
        this.damage = 0.0;
        this.damageModifier = 0.0;
        this.luck = 0;
        this.xCor = 0;
        this.yCor = 0;
        this.movement = 0;
        this.movementModifier = 0;
        this.teamColor = "";
        }
/*
Parameter Constructor
Parameters: symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor
 */
    public Unit(char symbol, String name, double health, double healthModifier,
                double damage, double damageModifier,
                int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
        this.teamColor = teamColor;
    }
// Getters and Setters
    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealthModifier() {
        return healthModifier;
    }

    public void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getxCor() {
        return xCor;
    }

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    public int getyCor() {
        return yCor;
    }

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovementModifier() {
        return movementModifier;
    }

    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }
/*
toString method
Parameters: None
Returns: String - the teamColor followed by a single space followed by the symbol
 */
    @Override
    public String toString(){
        return this.teamColor + " " + this.symbol;
    }
    public abstract Unit spawn();

    public abstract boolean canSpawn();

    public abstract boolean validMovePath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare);
    
    public abstract boolean validSpawnPath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare);
}
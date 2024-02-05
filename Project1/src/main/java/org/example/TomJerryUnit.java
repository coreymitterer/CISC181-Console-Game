package org.example;

public class TomJerryUnit extends Attacker {
    private boolean homingRocket; // can use special attack "homing rocket"
    private boolean offerCheese; // can use special ability "offer cheese"
    private boolean hiding; // is the unit hidden on the board

    // Constructor
    public TomJerryUnit(boolean homingRocket, boolean offerCheese,
            boolean hiding) {
        super('T', "Tom & Jerry", 100.0, 0.0, 100.0, 0.0, 0, 5, 5, 1, 0, "Unknown", 0);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;

    }

    // This is our default TomJerryUnit
    public TomJerryUnit() {
        this(true, true, false);
    }

    // Getters
    public boolean canHomingRocket() {
        return homingRocket;
    }

    public boolean canOfferCheese() {
        return offerCheese;
    }

    public boolean isHiding() {
        return hiding;
    }

    // Setters
    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

    public double dealDamage() {
        double totalDamage = damage + damageModifier;
        if (homingRocket) {
            totalDamage += 10;
        }
        return totalDamage;
    }

    public void takeDamage(double damage) {
        if (isHiding()) {
            health -= 0;
        } else {
            health -= damage;
        }
    }

    @Override
    public TomJerryUnit spawn() {
        return new TomJerryUnit(false, true, false);
    }

    public boolean canSpawn() {
        return true;
    }

    /*
     * Params: rowAttacker, colAttacker: represents the row and column that the
     * attacker lives on
     * rowAttacked, colAttacked: represents the row and column that the new
     * attackeded piece lives on
     * 
     * @Returns Boolean: representing whether the attacer is allowed to attack
     */
    @Override
    public boolean validAttackPath(int rowAttacker, int colAttacker, int rowAttacked, int colAttacked) {
        if (rowAttacker == rowAttacked) {
            return true;
        } else if ((colAttacker == colAttacked) && (Math.abs(rowAttacker - rowAttacked) == 2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validMovePath(int rowFromSquare, int colFromSquare, int rowToSquare, int colToSquare) {
        return true;
    }

    /*
     * Params: rowSpawner, colSpawner: represents the row and column that the
     * spawner lives on
     * rowSpawned, colSpawned: represents the row and column that the spawned piece
     * will live on
     * 
     * @Returns Boolean: representing whether the spawner is allowed to spawn on
     * that piece
     */
    @Override
    public boolean validSpawnPath(int rowSpawner, int colSpawner, int rowSpawned, int colSpawned) {
        return true;
    }
}

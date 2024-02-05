package org.example;
// New Unit Modification
public class TazUnit extends Attacker {
    private boolean tornado;

    public TazUnit(boolean tornado) {
        super('Z', "Taz", 100.0, 0.0, 100.0, 0, 1, 1, 1, 1, 0,
                "Unknown", 0);
        this.tornado = tornado; // represents part of his attack where he throws the unit he attacks
    }

    @Override
    public TazUnit spawn() {
        return new TazUnit(true);
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    public double dealDamage(){
        double totalDamage = damage + damageModifier;
        return totalDamage;
    }

    public void takeDamage(double damage) {
            health -= damage;
    }

    @Override
    public boolean validMovePath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        if (((rowFromSquare - rowToSquare == 0) || (Math.abs(rowFromSquare - rowToSquare) == 1)
                || (Math.abs(rowFromSquare - rowToSquare) == 2)) &&
                ((columnFromSquare - columnToSquare == 0) || (Math.abs(columnFromSquare - columnToSquare) == 1)
                        || (Math.abs(columnFromSquare - columnToSquare) == 2))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validSpawnPath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        if ((rowFromSquare - rowToSquare == 0) || (rowFromSquare - rowToSquare == Math.abs(1))
                || rowFromSquare - rowToSquare == Math.abs(2) &&
                        (columnFromSquare - columnToSquare == 0)
                || (columnFromSquare - columnToSquare == Math.abs(1))
                || (columnFromSquare - columnToSquare == Math.abs(2))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validAttackPath(int rowAttacker, int colAttacker, int rowAttacked, int colAttacked) {

        if ((rowAttacker - rowAttacked == 0) || (Math.abs(rowAttacker - rowAttacked) == 1)
                || (Math.abs(rowAttacker - rowAttacked) == 2) &&
                        (Math.abs(colAttacker - colAttacked) == 0)
                || (Math.abs(colAttacker - colAttacked) == 1) || (Math.abs(colAttacker - colAttacked) == 2)) {
            return true;
        } else {
            return false;
        }
    }

}

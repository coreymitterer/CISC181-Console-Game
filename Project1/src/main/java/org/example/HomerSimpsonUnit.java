package org.example;

// New Unit Modification
public class HomerSimpsonUnit extends BartSimpsonUnit {
    private boolean donutTime;

    public HomerSimpsonUnit(boolean donutTime) {
        super(0, false,
                true);
        this.donutTime = donutTime; // represents part of his attack where he throws the unit he attacks
        this.symbol = 'H';
    }

    @Override
    public HomerSimpsonUnit spawn() {
        return new HomerSimpsonUnit(true);
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean validMovePath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        if ((rowToSquare == 0) && (columnToSquare == 0)) {
            //System.out.println("1");
            return false;
        } else if ((rowToSquare == 0) && (columnToSquare == 7)) {
            //System.out.println("2");
            return false;
        } else if ((rowToSquare == 7) && (columnToSquare == 0)) {
            //System.out.println("3");
            return false;
        } else if ((rowToSquare == 7) && (columnToSquare == 7)) {
            //System.out.println("4");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validSpawnPath(int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        if ((Math.abs(rowFromSquare - rowToSquare) == 1) && (Math.abs(columnFromSquare - columnToSquare) == 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validRecruitPath(int rowRecruiter, int colRecruiter, int rowRecruit, int colRecruit) {
        if ((rowRecruit == 0) && (colRecruit == 0)) {
            return false;
        } else if ((rowRecruit == 0) && (colRecruit == 7)) {
            return false;
        } else if ((rowRecruit == 7) && (colRecruit == 0)) {
            return false;
        } else if ((rowRecruit == 7) && (colRecruit == 7)) {
            return false;
        } else {
            return true;
        }
    }

}

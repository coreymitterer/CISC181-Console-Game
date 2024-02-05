package org.example;
public class BartSimpsonUnit extends Recruiter {
    private int numTimesSpawned; //the number of times this piece has spawned
    private boolean distract; //can use special ability "distract"
    private boolean recruit; //can recruit other units
    final int MAX_NUM_SPAWNED = 2;
    
    public boolean isOriginal() {
        return getSymbol() == 'B';
    }

//Constructor
    public BartSimpsonUnit(int numTimesSpawned, boolean distract,
                           boolean recruit){
        super('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "Blue", 0);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }
//This is our default BartSimpsonUnit
public BartSimpsonUnit() {
        this(0, true, true);
}
//Getters and Setters

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public boolean canDistract() {
        return distract;
    }

    public void setDistract(boolean distract) {
        this.distract = distract;
    }

    public boolean canRecruit() {
        return recruit;
    }

    public void setRecruit(boolean recruit) {
        this.recruit = recruit;
    }

    public int getMAX_NUM_SPAWNED() {
        return MAX_NUM_SPAWNED;
    }
    public void distracted(){
        if (distract) {
            System.out.println("Unit Distracted");
        }
    }

    public boolean canSpawn() {
        return this.getNumTimesSpawned() < MAX_NUM_SPAWNED;
    }

    public BartSimpsonUnit spawn() {
        BartSimpsonUnit bart = new BartSimpsonUnit(0, true, true);

        this.numTimesSpawned ++;
        return bart;
    }

    /*
     * Params: rowRecruiter, colRecruiter: represents the row and column that the recruiter lives on
     *         rowRecruit, colRecruit: represents the row and column that the new recruited piece will live on
     * @Returns Boolean: representing whether the recruiter is allowed to recruit
     */
    @Override
    public boolean validRecruitPath(int rowRecruiter, int colRecruiter, int rowRecruit, int colRecruit) {

        if (colRecruiter == colRecruit){
             return true;
         }else if ((rowRecruiter == rowRecruit) && (Math.abs(colRecruiter - colRecruit) == 2)){
             return true;
         }else {
             return false;
         }

    }

    /*
     * Params: rowFromSquare, colFromSquare: represents the row and column that the recruiter lives on
     *         rowToSquare, colToSquare: represents the row and column that the new recruiter will move to
     * @Returns Boolean: representing whether the recruiter is allowed to move
     */
    
     @Override
    public boolean validMovePath(int rowFromSquare, int colFromSquare, int rowToSquare, int colToSquare) {

        if (colFromSquare == colToSquare){
            return true;
        }else if ((rowFromSquare == rowToSquare) && (Math.abs(colFromSquare - colToSquare) == 2)){
            return true;
        }else {
            return false;
        }
    }

    /*
     * Params: rowSpawner, colSpawner: represents the row and column that the spawner lives on
     *         rowSpawned, colSpawned: represents the row and column that the new spawned piece will live on
     * @Returns Boolean: representing whether the recruiter is allowed to recruit
     */
    @Override
    public boolean validSpawnPath(int rowSpawner, int colSpawner, int rowSpawned, int colSpawned) {
        if (colSpawner == colSpawned){
            return true;
        }else if ((rowSpawner == rowSpawned) && (Math.abs(colSpawner - colSpawned) == 2)){
            return true;
        }else {
            return false;
        }
    }
}

package org.example;
abstract class Action {
    protected Game game;
    protected int rowFromSquare;//The row value of the Attacking or Recruiting Unit
    protected int columnFromSquare; // The column value of the Attacking or Recruiting Unit
    protected int rowToSquare;//The row value of the Unit that is being recruited or attacked
    protected int columnToSquare; //The column value of the unit that is being recrutied or attacked

    public Action(Game game, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        this.game = game;
        this.rowFromSquare = rowFromSquare;
        this.columnFromSquare= columnFromSquare;
        this.rowToSquare = rowToSquare;
        this.columnToSquare = columnToSquare;
    }

    public abstract void performAction();
    /**
     * This method will be implemented in all the subclasses
     * @return void
     */
}
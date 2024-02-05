package org.example;

public class ActionSpawn extends Action {

    public ActionSpawn(Game game, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(game, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    /*
     * Calls the unit on the from square spawn method
     * Adds the unit that was created to the current team
     * Puts the Unit that was created onto the board
     * Changes turns
     * Returns void
     */
    @Override
    public void performAction() {
        Unit spawnedUnit = game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].getUnit();
        spawnedUnit.spawn();
        game.getCurrentPlayer().getTeam().addUnitsToTeam(spawnedUnit);
        game.getGameBoard().getSquares()[rowToSquare][columnToSquare].setUnit(spawnedUnit);
        game.changeTurn();
    }

    @Override
    public String toString() {

        return game.getOpponentPlayer().getTeam().getTeamColor() + " teams "
                + game.getBoardSquares()[rowToSquare][columnToSquare]
                        .getUnit().getName()
                + " unit on " + rowFromSquare + "," + columnFromSquare + " spawns a unit on " + rowToSquare + ","
                + columnToSquare;

    }

}

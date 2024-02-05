package org.example;


public class ActionRecruit extends Action {

    public ActionRecruit(Game game, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare) {
        super(game, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }
    /*
    Removes the Unit that was recruited from the opponents team
    Adds the unit that was recruited to the current team
    Changes turn
    @Returns void
     */
    @Override
    public void performAction() {
        Unit recruit = game.getGameBoard().getSquares()[rowToSquare][columnToSquare].getUnit();
        game.getOpponentPlayer().getTeam().removeUnitsFromTeam(recruit);
        game.getCurrentPlayer().getTeam().addUnitsToTeam(recruit);
        game.changeTurn();
        
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getTeam().getTeamColor() + " teams "
                + game.getBoardSquares()[rowToSquare][columnToSquare]
                        .getUnit().getName()
                + " unit on " + rowFromSquare + "," + columnFromSquare + " recruits a unit on " + rowToSquare + ","
                + columnToSquare;

    }
}
package org.example;


public class ActionMove extends Action{

    public ActionMove(Game game, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare){
        super(game, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }

    @Override
    public void performAction() {
        /*
          Remove Unit on ‘from square’
          Set Unit onto ‘to square’
          Change the turn
          Returns void
         */
        Unit unit = game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].getUnit();
        game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].removeUnit();
        game.getGameBoard().getSquares()[rowToSquare][columnToSquare].setUnit(unit);
        game.changeTurn();
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getTeam().getTeamColor() + " teams "
                + game.getBoardSquares()[rowToSquare][columnToSquare] // changed rowFromSquare to rowToSquare and same for column
                        .getUnit().getName()
                + " unit moves from " + rowFromSquare + "," + columnFromSquare + " to " + rowToSquare + ","
                + columnToSquare;

    }
}

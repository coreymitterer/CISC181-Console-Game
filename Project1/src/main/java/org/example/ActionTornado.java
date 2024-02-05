package org.example;

// New Action Modification
public class ActionTornado extends Action {
    public ActionTornado(Game game, int rowFromSquare, int columnFromSquare) {
        super(game, rowFromSquare, columnFromSquare, 0, 0);
    }

    @Override
    public void performAction() {
        BoardSquare randomSquare = game.getGameBoard().findRandomEmptySpace();
        Unit unit = game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].getUnit();
        game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].removeUnit();
        // game.getGameBoard().getSquares()[rowToSquare][columnToSquare].setUnit(unit);
        randomSquare.setUnit(unit);
        // New Rule Modification
        // When you perform ActionTornado it does not change the player's turn
    }

    @Override
    public String toString() {
        Unit unit = game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare].getUnit();
        return game.getCurrentPlayer().getTeam().getTeamColor() + " teams "
                + unit
                + "tornado'd from " + rowFromSquare + ", " + columnFromSquare + " to " + rowToSquare + ", "
                + columnToSquare;

    }
}

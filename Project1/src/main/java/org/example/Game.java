package org.example;
import java.util.Collections;

public class Game {
    private GameBoard board;
    private Player p1;
    private Player p2;
    private BoardSquare specialSquare;


    private void initializeGameBoard(int rows, int cols) {
        board = new GameBoard(rows, cols);
        for (Unit unit1 : p1.getTeam().getTeamUnits()) {
            BoardSquare square = board.findRandomEmptySpace();
            square.setUnit(unit1);
        }
        for (Unit unit2 : p2.getTeam().getTeamUnits()) {
            BoardSquare square = board.findRandomEmptySpace();
            square.setUnit(unit2);
        }
        
        setSpecialSquare();
    }

    public BoardSquare getSpecialSquare() {
        return specialSquare;
    }

    public void setSpecialSquare() {
        specialSquare = board.findRandomEmptySpace();
        specialSquare.setSpecialSquare(true);
    }

    public Game(int rows, int cols, Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        initializeGameBoard(rows, cols);
    }

    public GameBoard getGameBoard() {
        return this.board;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getCurrentPlayer() {
        return p2.isTurn() ? p2 : p1;
    }

    public Player getOpponentPlayer() {
        return p2.isTurn() ? p1 : p2;
    }

    public boolean isTurn(Player currentPlayer) {
        return (getCurrentPlayer() == currentPlayer);
    }

    public int getSize(Player player) {
        return player.getTeam().getTeamUnits().size();
    }

    public BoardSquare[][] getBoardSquares() {
        return getGameBoard().getSquares();
    }

    public void changeTurn() {
        p1.setTurn(!p1.isTurn());
        p2.setTurn(!p2.isTurn());
    }

    public boolean isAWinner() {
        int teamSizePlayerOne = p1.getTeam().getTeamUnits().size();
        int teamSizePlayerTwo = p2.getTeam().getTeamUnits().size();
        boolean playerOneWin = (teamSizePlayerOne > 0 && teamSizePlayerTwo == 0);
        boolean playerTwoWin = (teamSizePlayerTwo > 0 && teamSizePlayerOne == 0);

        return playerOneWin ^ playerTwoWin;
    }

    public Player getWinner() {
        // getWinner – that has no parameters and returns a Player. This should be
        // similar to the
        // idea from the first few Labs (see below) but now we compare team sizes.
        // Return the winning Player
        while (isGameEnded()) {
            int teamAHealth = 0;
            int teamBHealth = 0;
            for (Unit unit : p1.getTeam().getTeamUnits()) {
                teamAHealth += unit.getHealth();
            }
            for (Unit unit : p2.getTeam().getTeamUnits()) {
                teamBHealth += unit.getHealth();
            }
            if (teamAHealth > teamBHealth) {
                return p1;
            } else if (teamAHealth < teamBHealth) {
                return p2;
            }
            if (teamAHealth == 0){
                return p2;
            }
            else if (teamBHealth == 0){
                return p1;
            }
        }
        return null;
    }

    // New Objective Modification
    // The game ends once a certain player has enough units where the total health between all of the units is 800 or greater
    public boolean isGameEnded() {
        int teamAHealth = 0;
        int teamBHealth = 0;

        for (Unit unit : p1.getTeam().getTeamUnits()) {
            teamAHealth += unit.getHealth();
        }

        for (Unit unit : p2.getTeam().getTeamUnits()) {
            teamBHealth += unit.getHealth();
        }

        if (teamAHealth >= 800 || teamBHealth >= 800) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "")))
                .append("\n" + getCurrentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "")))
                .append("\n" + getOpponentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s ("
                        + getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }
}

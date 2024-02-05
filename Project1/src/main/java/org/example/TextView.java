package org.example;
import java.util.Scanner;

public class TextView {

    private int rowIndexFrom;
    private int colIndexFrom;
    private int rowIndexTo;
    private int colIndexTo;
    private char actionType;

    public int getRowFromSquare() {
        /**
         * This method represents row index of board square with Unit making Action
         * (From Square)
         * 
         * @return This method returns the row index of board square with Unit making
         *         Action
         */
        return this.rowIndexFrom;
    }

    public int getColumnFromSquare() {
        /**
         * This method represents column index of board square with Unit making Action
         * (From Square)
         * 
         * @return This method returns the column index of board square with Unit making
         *         Action
         */
        return this.colIndexFrom;
    }

    public int getRowToSquare() {
        /**
         * This method represents row index of the board square to be receiving the
         * Action (To Square)
         * 
         * @return This method returns the row index of the board square to be receiving
         *         the Action
         */
        return this.rowIndexTo;
    }

    public int getColumnToSquare() {
        /**
         * This method represents column index of the board square to be receiving the
         * Action (To Square)
         * 
         * @return This method returns the column index of the board square to be
         *         receiving the Action
         */
        return this.colIndexTo;
    }

    public char getActionType() {
        /**
         * This method represents the action type chosen by player
         * 
         * @return This method returns the action type chosen by player
         */
        return this.actionType;
    }

    public static int getValidInt(int minValAllowed, int maxValAllowed, Scanner scanner) {
        /**
         ** This method uses a while loop to repeatedly ask the user to enter an integer
         * in the range indicated
         * by the arguments passed to the method until the user enters an integer in
         * that range.
         * 
         * @param minInteger This parameter represents the minimum integer value allowed
         *                   to be entered by the user
         * @param maxInteger This parameter represents the maximum integer value allowed
         *                   to be entered by the user
         * @param scnr       This parameter is an instance of Scanner object used to get
         *                   two values from the user
         * @return This method returns the first entry that is in range should be
         *         returned by this method.
         */
        int input = 0;
        boolean canReadInput = false;

        while (!canReadInput) {
            System.out.println("Enter a value between " + minValAllowed + " and " + maxValAllowed + ": ");

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                canReadInput = ((input >= minValAllowed) && (input <= maxValAllowed));
            } else {
                scanner.next();
            }
        }

        return input;
    }

    public void getNextPlayersAction(Game game) {
        /**
         * This method gets the action that the user would like to preform and gets the
         * rows and columns of the to and from squares
         * 
         * @param game This parameter represents the game that is currently being played
         */
        System.out.println(game.toString());
        actionType = getUsersNextActionType(new Scanner(System.in));
        System.out.println("\nEnter the from piece's row coordinate");
        rowIndexFrom = getValidInt(0, game.getGameBoard().getNumRows(), new Scanner(System.in));

        System.out.println("\nEnter the from piece's column coordinate");
        colIndexFrom = getValidInt(0, game.getGameBoard().getNumColumns(), new Scanner(System.in));

        if (!(actionType == 'T' || actionType == 't')) {
            System.out.println("\nEnter the to piece's row coordinate");
            rowIndexTo = getValidInt(0, game.getGameBoard().getNumRows(), new Scanner(System.in));

            System.out.println("\nEnter the to piece's column coordinate");
            colIndexTo = getValidInt(0, game.getGameBoard().getNumColumns(), new Scanner(System.in));
        }
    }

    public static char getUsersNextActionType(Scanner input) {
        /**
         * This method uses a while loop to repeatedly ask the user to enter one valid
         * characters. The first
         * character from the valid characters entered by the user should be returned by
         * this method.
         * 
         * @param scnr This parameter is an instance of Scanner object used to get the
         *             users input
         * @return This method returns the first valid input entered by the user
         */
        System.out.println("""
                Choose Your action:
                ∙ A (representing attack)\s
                ∙ M (representing move)\s
                ∙ R (representing recruit)\s
                ∙ S (representing spawn)\s
                ∙ T (representing tornado - Taz Only)""");

        while (true) {
            String val = input.nextLine();
            switch (val) {
                case "A", "a", "M", "m", "S", "s", "R", "r", "T", "t" -> {
                    return val.toUpperCase().charAt(0);
                }
            }

            if (!(val.contains("A") || val.contains("a") || val.contains("S")
                    || val.contains("s") || val.contains("M") || val.contains("m")
                    || val.contains("R") || val.contains("r") || val.contains("T") || val.contains("t"))) {
                System.out.println("""
                        Choose Your action:
                        ∙ A (representing attack)\s
                        ∙ M (representing move)\s
                        ∙ R (representing recruit)\s
                        ∙ S (representing spawn)\s
                        ∙ T (representing tornado - Taz Only)""");
            }
        }
    }

    public void updateView(Game game) {
        /**
         * This method prints the game object
         * 
         * @param game This parameter represents the game that is currently being played
         */
        System.out.println(game);
    }

    public void printEndOfGameMessage(Game game) {
        /**
         * This method displays a message stating the game ended and which team won
         * 
         * @param game This parameter represents the game that is currently being played
         */
        
        if (game.getWinner() == game.getP1()){
            System.out.println("Player 1 wins!");
            System.exit(0);
        } 
        if (game.getWinner() == game.getP2()){
            System.out.println("Player 2 wins");
            System.exit(0);
        }
        if (game.getWinner() == null) {
            System.out.println("It's a tie!");
            System.exit(0);
        }
    }
}
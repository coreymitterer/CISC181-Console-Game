package org.example;
public class Rules {
    public static boolean checkValidAction(Game gamePlaying, int rowFromSquare, int columnFromSquare, int rowToSquare,
            int columnToSquare, char actionType) {
        BoardSquare toSquare = gamePlaying.getGameBoard().getSquares()[rowToSquare][columnToSquare];
        BoardSquare fromSquare = gamePlaying.getGameBoard().getSquares()[rowFromSquare][columnFromSquare];

        // REMOVE REMOVE REMOVE
        //System.out.println("check action");

        if (gamePlaying.getGameBoard().inBounds(rowFromSquare, columnFromSquare)
                && gamePlaying.getGameBoard().inBounds(rowToSquare, columnToSquare)) {

            // REMOVE REMOVE REMOVE
            // System.out.println(gamePlaying.getGameBoard().inBounds(rowFromSquare, columnFromSquare));
            // System.out.println(gamePlaying.getGameBoard().inBounds(rowToSquare, columnToSquare));
            // System.out.println(!fromSquare.isEmpty());
            // System.out.println(gamePlaying.getCurrentPlayer().getTeam().getTeamColor());
            // System.out.println(fromSquare.getUnit().getTeamColor());


            if ((!fromSquare.isEmpty()) && (gamePlaying.getCurrentPlayer().getTeam().getTeamColor() == fromSquare
                    .getUnit().getTeamColor())) {
                if (actionType == 'M') {
                    if (toSquare.isEmpty() && fromSquare.getUnit().validMovePath(rowFromSquare, columnFromSquare,
                            rowToSquare, columnToSquare)) {
                        /*
                         * Board Square Modification
                         * Our modification chooses a random square on the board and if the unit lands
                         * on this square,
                         * the unit will switch teams.
                         */
                        if (toSquare == gamePlaying.getSpecialSquare()) {
                            Unit tempUnit = fromSquare.getUnit();
                            System.out.println("You landed on the special square! Your unit has switched teams!");
                            gamePlaying.getCurrentPlayer().getTeam().removeUnitsFromTeam(tempUnit);
                            gamePlaying.getOpponentPlayer().getTeam().addUnitsToTeam(tempUnit);
                        }
                        return true;
                    }
                }
                if (actionType == 'S') {
                    if (toSquare.isEmpty() && fromSquare.getUnit().validSpawnPath(rowFromSquare, columnFromSquare,
                            rowToSquare, columnToSquare)) {
                        return true;
                    }
                }
                if (actionType == 'R') {
                    if ((fromSquare.getUnit() instanceof BartSimpsonUnit && !toSquare.isEmpty()) || (fromSquare.getUnit() instanceof HomerSimpsonUnit && !toSquare.isEmpty())) {
                        // if(gamePlaying.getOpponentPlayer().getTeam().getTeamColor() ==
                        // toSquare.getUnit().getTeamColor()){
                        if (((BartSimpsonUnit) fromSquare.getUnit()).validRecruitPath(rowFromSquare, columnFromSquare,
                                rowToSquare, columnToSquare)) {
                            return true;
                        }
                        // }
                    }
                }
                if (actionType == 'A') {
                    System.out.println("Passes0");
                    if ((fromSquare.getUnit() instanceof TomJerryUnit && (!toSquare.isEmpty())) || (fromSquare.getUnit() instanceof TazUnit && (!toSquare.isEmpty()))) {
                        System.out.println("Passes1");
                        if (gamePlaying.getOpponentPlayer().getTeam().getTeamColor() == toSquare.getUnit()
                                .getTeamColor()) {
                            System.out.println("Passes2");
                            if (fromSquare.getUnit() instanceof TomJerryUnit) {
                                if (((TomJerryUnit) fromSquare.getUnit()).validAttackPath(rowFromSquare, columnFromSquare,
                                        rowToSquare, columnToSquare)){
                                    return true;
                                }
                            }
                            else if(fromSquare.getUnit() instanceof TazUnit){
                                if (((TazUnit) fromSquare.getUnit()).validAttackPath(rowFromSquare, columnFromSquare,
                                        rowToSquare, columnToSquare)) {
                                    System.out.println("Passes3");
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (actionType == 'T') {
                    if (gamePlaying.getGameBoard().getSquares()[rowFromSquare][columnFromSquare]
                            .getUnit() instanceof TazUnit) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

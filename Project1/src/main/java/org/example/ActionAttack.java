package org.example;

public class ActionAttack extends Action{

    public ActionAttack(Game game, int rowFromSquare, int columnFromSquare, int rowToSquare, int columnToSquare){
        super(game, rowFromSquare, columnFromSquare, rowToSquare, columnToSquare);
    }



    
    @Override
    public void performAction() {

        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFromSquare][columnFromSquare];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowToSquare][columnToSquare];
        if(toSquare.getUnit() instanceof Attacker){

            double dealDamage = (fromSquare.getUnit()).damage;

            if(toSquare.getUnit() instanceof TomJerryUnit){

                ((TomJerryUnit)toSquare.getUnit()).takeDamage(dealDamage);
                System.out.println(toSquare.getUnit().getHealth());
            }
            if(toSquare.getUnit() instanceof TazUnit){

                ((TazUnit)toSquare.getUnit()).takeDamage(dealDamage);
            }


            if(toSquare.getUnit().getHealth() <= 0){

                Unit tempUnit = toSquare.getUnit();

                toSquare.removeUnit();
                game.getOpponentPlayer().getTeam().removeUnitsFromTeam(tempUnit);
                // Line below moves the attacker to the square that it attacked
                toSquare.setUnit(fromSquare.getUnit());
                fromSquare.removeUnit();
                game.changeTurn();
            }
        }
        else if(toSquare.getUnit() instanceof Recruiter){
            Unit tempUnit = toSquare.getUnit();

            toSquare.removeUnit();
            game.getOpponentPlayer().getTeam().removeUnitsFromTeam(tempUnit);
            // Line below moves the attacker to the square that it attacked
            toSquare.setUnit(fromSquare.getUnit());
            fromSquare.removeUnit();
            game.changeTurn();
        }
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getTeam().getTeamColor() + " teams "
                + game.getBoardSquares()[rowToSquare][columnToSquare]
                        .getUnit().getName()
                + " unit on " + rowFromSquare + "," + columnFromSquare + " attacks a unit on " + rowToSquare + ","
                + columnToSquare;

    }
}
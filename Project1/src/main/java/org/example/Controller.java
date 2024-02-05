package org.example;

import java.util.*;


// This class will interact with the View and the Game Model to allow players to play our game
public class Controller {

    private Game game;
    private TextView textView;
    private GameEventsLinkedList gameEventsLinkedList;

    public Controller() {
        game = setUpGameModel();
        gameEventsLinkedList = new GameEventsLinkedList();
        textView = new TextView();
        // textView.updateView(game);
    }

    public void playGame() {
        boolean gameEnded = false;
        boolean valid = false;


        while (!gameEnded) {
            // textView.updateView(game);

            textView.getNextPlayersAction(game);
            valid = Rules.checkValidAction(game, textView.getRowFromSquare(), textView.getColumnFromSquare(),
                textView.getRowToSquare(), textView.getColumnToSquare(), textView.getActionType());

            while (!valid) {
                // textView.updateView(game);
                System.out.println("Invalid square, try again.");
                textView.getNextPlayersAction(game);

                valid = Rules.checkValidAction(game, textView.getRowFromSquare(), textView.getColumnFromSquare(),
                        textView.getRowToSquare(), textView.getColumnToSquare(), textView.getActionType());

            }
            carryOutAction(textView.getRowFromSquare(), textView.getColumnFromSquare(), textView.getRowToSquare(),
                    textView.getColumnToSquare(), textView.getActionType());
            // textView.updateView(game);

            if (game.isGameEnded()) {
                textView.updateView(game);
                gameEnded = true;
            }

            //textView.getNextPlayersAction(game);
            // valid = Rules.checkValidAction(game, textView.getRowFromSquare(), textView.getColumnFromSquare(),
            //         textView.getRowToSquare(), textView.getColumnToSquare(), textView.getActionType());
        }

        GameEventsLinkedList.GameEvent lastGameEvent = gameEventsLinkedList.pop();
        System.out.println("Winning Move: " + lastGameEvent.getEventDetails());

        textView.printEndOfGameMessage(game);

        GameEventsLinkedList attackLinkedList = gameEventsLinkedList.pop("Attack");
        GameEventsLinkedList moveLinkedList = gameEventsLinkedList.pop("Move");
        GameEventsLinkedList recruitLinkedList = gameEventsLinkedList.pop("Recruit");
        GameEventsLinkedList spawnLinkedList = gameEventsLinkedList.pop("Spawn");
        GameEventsLinkedList tornadoLinkedList = gameEventsLinkedList.pop("Tornado");
        ArrayList<GameEventsLinkedList> eventsArray = new ArrayList<>();

        eventsArray.add(attackLinkedList);
        eventsArray.add(moveLinkedList);
        eventsArray.add(recruitLinkedList);
        eventsArray.add(spawnLinkedList);
        eventsArray.add(tornadoLinkedList);

        Collections.sort(eventsArray, Collections.reverseOrder());
        for (int i = 0; i < eventsArray.size(); i++) {
            System.out.println(eventsArray.get(i).size);
            GameEventsLinkedList.GameEventNode current = eventsArray.get(i).head;
            while (current.getNext() != null) {
                System.out.println(current.getGameState().getEventType());
                current = current.getNext();
            }
        }
    }

    public void carryOutAction(int rowIndexFrom, int colIndexFrom, int rowIndexTo, int colIndexTo, char actionType) {

        // REMOVE REMOVE REMOVE
        // System.out.println("CARRY");

        if (actionType == 'a' || actionType == 'A') {
            Action attack = new ActionAttack(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            attack.performAction();
            GameEventsLinkedList.GameEvent eventAttack = new GameEventsLinkedList.GameEvent(
                    game.getCurrentPlayer().getPlayerNumber(), "Attack", attack.toString());
            GameEventsLinkedList.GameEventNode attackNode = new GameEventsLinkedList.GameEventNode(eventAttack, null);
            gameEventsLinkedList.push(attackNode);
        }

        if (actionType == 'm' || actionType == 'M') {
            Action move = new ActionMove(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            move.performAction();
            GameEventsLinkedList.GameEvent eventMove = new GameEventsLinkedList.GameEvent(
                    game.getCurrentPlayer().getPlayerNumber(), "Move", move.toString());
            GameEventsLinkedList.GameEventNode moveNode = new GameEventsLinkedList.GameEventNode(eventMove, null);
            gameEventsLinkedList.push(moveNode);
        }

        if (actionType == 'r' || actionType == 'R') {
            Action recruit = new ActionRecruit(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            recruit.performAction();
            GameEventsLinkedList.GameEvent eventRecruit = new GameEventsLinkedList.GameEvent(
                    game.getCurrentPlayer().getPlayerNumber(), "Recruit", recruit.toString());
            GameEventsLinkedList.GameEventNode recruitNode = new GameEventsLinkedList.GameEventNode(eventRecruit, null);
            gameEventsLinkedList.push(recruitNode);
        }

        if (actionType == 's' || actionType == 'S') {
            Action spawn = new ActionSpawn(game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            spawn.performAction();
            GameEventsLinkedList.GameEvent eventSpawn = new GameEventsLinkedList.GameEvent(
                    game.getCurrentPlayer().getPlayerNumber(), "Spawn", spawn.toString());
            GameEventsLinkedList.GameEventNode spawnNode = new GameEventsLinkedList.GameEventNode(eventSpawn, null);
            gameEventsLinkedList.push(spawnNode);
        }

        if (actionType == 't' || actionType == 'T') {
            Action tornado = new ActionTornado(game, rowIndexFrom, colIndexFrom);
            tornado.performAction();
            GameEventsLinkedList.GameEvent eventTornado = new GameEventsLinkedList.GameEvent(
                    game.getCurrentPlayer().getPlayerNumber(), "Tornado", tornado.toString());
            GameEventsLinkedList.GameEventNode tornadoNode = new GameEventsLinkedList.GameEventNode(eventTornado, null);
            gameEventsLinkedList.push(tornadoNode);
        }

    }

    public Game setUpGameModel() {

        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();

        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");

        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");

        TazUnit tz = new TazUnit(true);
        tz.setTeamColor("Blu");

        HomerSimpsonUnit hs = new HomerSimpsonUnit(true);
        hs.setTeamColor("Blu");

        piecesTeamA.add(bs);
        piecesTeamA.add(tj);
        piecesTeamA.add(tz);
        piecesTeamA.add(hs);

        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);
        Player playerOne = new Player(1, true, teamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();

        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");

        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");

        TazUnit tz2 = new TazUnit(true);
        tz2.setTeamColor("Red");

        HomerSimpsonUnit hs2 = new HomerSimpsonUnit(true);
        hs2.setTeamColor("Red");

        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);
        piecesTeamB.add(tz2);
        piecesTeamB.add(hs2);

        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);

        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public static void main(String[] args) {
        Controller playerController = new Controller();
        playerController.playGame();
    }

}

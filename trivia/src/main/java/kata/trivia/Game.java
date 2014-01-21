package kata.trivia;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    QuestionMaker questionMaker = new QuestionMaker();
    private List<Player> players = new ArrayList<Player>();
    private int[] purses  = new int[6];

    int currentPlayer = 0;

    public  Game(){
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
        purses[howManyPlayers()] = 0;

        MyLogger.log(playerName + " was added");
        MyLogger.log("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void processDiceRollingNumber(int diceRollingNumber) {
        MyLogger.log(players.get(currentPlayer).getName() + " is the current player");
        MyLogger.log("They have rolled a " + diceRollingNumber);

        players.get(currentPlayer).processPenaltyBoxAndMovingForward(diceRollingNumber);

        MyLogger.log("The category is " + questionMaker.currentCategory(players.get(currentPlayer)));
        questionMaker.askQuestion(players.get(currentPlayer));
    }


    public boolean wasCorrectlyAnswered() {
        if (players.get(currentPlayer).isInPenaltyBox()){
            if (players.get(currentPlayer).isGettingOutOfPenaltyBox()) {
                MyLogger.log("Answer was correct!!!!");
                purses[currentPlayer]++;
                MyLogger.log(players.get(currentPlayer).getName()
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean playerNotWon = playerNotWonYet();
                nextPlayer();

                return playerNotWon;
            } else {
                nextPlayer();
                return true;
            }
        } else {

            MyLogger.log("Answer was corrent!!!!");
            purses[currentPlayer]++;
            MyLogger.log(players.get(currentPlayer).getName()
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean playerNotWon = playerNotWonYet();
            nextPlayer();

            return playerNotWon;
        }
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }

    public boolean wrongAnswer(){
        MyLogger.log("Question was incorrectly answered");
        MyLogger.log(players.get(currentPlayer).getName() + " was sent to the penalty box");
        players.get(currentPlayer).sentToPenaltyBox();

        nextPlayer();
        return true;
    }


    private boolean playerNotWonYet() {
        return !(purses[currentPlayer] == 6);
    }

    public String getNameOfCurrentPlayer() {
        return players.get(currentPlayer).getName();
    }

    public int getNumberOfGoldCoinsOfCurrentPlayer() {
        return purses[currentPlayer];
    }

    public boolean isCurrentPlayerInPenaltyBox() {
        return players.get(currentPlayer).isInPenaltyBox();
    }

    public boolean isPreviousPlayerOfCurrentPlayerInPenaltyBox() {
        return players.get(currentPlayer - 1).isInPenaltyBox();
    }

    public boolean isNextPlayerOfCurrentPlayerInPenaltyBox() {
        return players.get(currentPlayer + 1).isInPenaltyBox();
    }

    public boolean isCurrentPlayerGettingOutOfPenaltyBox() {
        return players.get(currentPlayer).isGettingOutOfPenaltyBox();
    }
}

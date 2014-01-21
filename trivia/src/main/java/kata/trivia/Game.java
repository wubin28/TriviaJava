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

        if (!currentPlayerIsInPenaltyBoxAndNotGettingOutOfIt()) {
            MyLogger.log("The category is " + questionMaker.currentCategory(players.get(currentPlayer)));
            questionMaker.askQuestion(players.get(currentPlayer));
        }
    }

    private boolean currentPlayerIsInPenaltyBoxAndNotGettingOutOfIt() {
        return (players.get(currentPlayer).isInPenaltyBox() && !players.get(currentPlayer).isGettingOutOfPenaltyBox());
    }


    public boolean wasCorrectlyAnswered() {
        boolean gameNotOver = true;
        if (players.get(currentPlayer).isInPenaltyBox()){
            if (players.get(currentPlayer).isGettingOutOfPenaltyBox()) {
                currentPlayerWinsAGoldCoin();

                gameNotOver = playerNotWonYet();
            }
        } else {

            MyLogger.log("Answer was corrent!!!!");
            purses[currentPlayer]++;
            MyLogger.log(players.get(currentPlayer).getName()
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            gameNotOver = playerNotWonYet();
        }
        nextPlayer();
        return gameNotOver;
    }

    private void currentPlayerWinsAGoldCoin() {
        MyLogger.log("Answer was correct!!!!");
        purses[currentPlayer]++;
        MyLogger.log(players.get(currentPlayer).getName()
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
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

    public boolean processQuestionAnswering(int randomNumber) {
        boolean gameNotOver = true;
        if (!currentPlayerIsInPenaltyBoxAndNotGettingOutOfIt()) {
            if (randomNumber == 7) {
                gameNotOver = wrongAnswer();
            } else {
                gameNotOver = wasCorrectlyAnswered();
            }
        }
        return gameNotOver;
    }
}

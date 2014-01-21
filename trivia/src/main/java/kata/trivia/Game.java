package kata.trivia;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    QuestionMaker questionMaker = new QuestionMaker();
    private List<Player> players = new ArrayList<Player>();
    private int[] purses  = new int[6];
    private boolean[] inPenaltyBox  = new boolean[6];

    int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    public  Game(){
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean addPlayer(String playerName) {


        players.add(new Player(playerName));
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        MyLogger.log(playerName + " was added");
        MyLogger.log("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        MyLogger.log(players.get(currentPlayer).getName() + " is the current player");
        MyLogger.log("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                MyLogger.log(players.get(currentPlayer).getName() + " is getting out of the penalty box");
                players.get(currentPlayer).moveForward(roll);

                MyLogger.log(players.get(currentPlayer).getName()
                        + "'s new location is "
                        + players.get(currentPlayer).getPlace());
                MyLogger.log("The category is " + questionMaker.currentCategory(players.get(currentPlayer)));
                questionMaker.askQuestion(players.get(currentPlayer));
            } else {
                MyLogger.log(players.get(currentPlayer).getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            players.get(currentPlayer).moveForward(roll);

            MyLogger.log(players.get(currentPlayer).getName()
                    + "'s new location is "
                    + players.get(currentPlayer).getPlace());
            MyLogger.log("The category is " + questionMaker.currentCategory(players.get(currentPlayer)));
            questionMaker.askQuestion(players.get(currentPlayer));
        }

    }


    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]){
            if (isGettingOutOfPenaltyBox()) {
                MyLogger.log("Answer was correct!!!!");
                purses[currentPlayer]++;
                MyLogger.log(players.get(currentPlayer).getName()
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean playerNotWon = playerNotWonYet();
                currentPlayer++;
                if (currentPlayer == players.size()) {
                    currentPlayer = 0;
                }

                return playerNotWon;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) {
                    currentPlayer = 0;
                }
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
            currentPlayer++;
            if (currentPlayer == players.size()) {
                currentPlayer = 0;
            }

            return playerNotWon;
        }
    }

    public boolean wrongAnswer(){
        MyLogger.log("Question was incorrectly answered");
        MyLogger.log(players.get(currentPlayer).getName() + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
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
        return inPenaltyBox[currentPlayer];
    }

    public boolean isPreviousPlayerOfCurrentPlayerInPenaltyBox() {
        return inPenaltyBox[currentPlayer - 1];
    }

    public boolean isNextPlayerOfCurrentPlayerInPenaltyBox() {
        return inPenaltyBox[currentPlayer + 1];
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }
}

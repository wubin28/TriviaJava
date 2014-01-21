package kata.trivia;

import java.util.Random;

/**
 * User: Ben
 * Date: 14-1-16
 * Time: 上午8:47
 */
public class GameRunner {

    private static boolean notAWinner;

    private GameRunner() {

    }

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        Random rand = new Random();

        do {
            aGame.processDiceRollingNumber(rand.nextInt(5) + 1);
            processQuestionAnswering(aGame, rand.nextInt(9));
        } while (notAWinner);
    }

    private static void processQuestionAnswering(Game aGame, int randomNumber) {
        if (randomNumber == 7) {
            notAWinner = aGame.wrongAnswer();
        } else {
            notAWinner = aGame.wasCorrectlyAnswered();
        }
    }
}

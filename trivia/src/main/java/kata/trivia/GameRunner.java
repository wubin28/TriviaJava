package kata.trivia;

import java.util.Random;

/**
 * User: Ben
 * Date: 14-1-16
 * Time: 上午8:47
 */
public class GameRunner {
    private GameRunner() {
    }

    public static void main(String[] args) {
        boolean gameNotOver;
        Game aGame = new Game();

        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        Random rand = new Random();

        do {
            aGame.processDiceRollingNumber(rand.nextInt(5) + 1);
            gameNotOver = aGame.processQuestionAnswering(rand.nextInt(9));
        } while (gameNotOver);
    }

}

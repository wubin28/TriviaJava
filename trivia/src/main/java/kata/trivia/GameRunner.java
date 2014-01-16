package kata.trivia;

import java.util.Random;

/**
 * User: Ben
 * Date: 14-1-16
 * Time: 上午8:47
 */
public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        Random rand = new Random();

        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.isOver();
            }



        } while (notAWinner);

    }
}

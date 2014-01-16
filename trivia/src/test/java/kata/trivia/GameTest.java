package kata.trivia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Ben
 * Date: 14-1-16
 * Time: 上午8:49
 */
@RunWith(JUnit4.class)
public class GameTest {

    @Test
    public void WHEN_APlayerGotSixGoldCoins_THEN_GameIsOver() {
        // Given
        Game game = new Game();

        // When
        // Then
        game.addPlayer("Chet");

        for (int i = 0; i < 5; i++) {
            game.roll(4);
            assertEquals("Failure - ", true, game.isNotOver());
        }
        assertEquals("Failure - ", false, game.isNotOver());
    }
}

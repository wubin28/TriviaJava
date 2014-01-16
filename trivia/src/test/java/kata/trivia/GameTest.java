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
    public void characterizingMethod_wasCorrectlyAnswered() {
        // Given
        Game game = new Game();

        // When
        // Then
        game.add("Chet");

        // 1
        game.roll(4);
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());

        // 2
        game.roll(4);
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());

        // 3
        game.roll(4);
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());

        // 4
        game.roll(4);
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());

        // 5
        game.roll(4);
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());

        // 6
        game.roll(4);
        assertEquals("Failure - ", false, game.wasCorrectlyAnswered());
    }
}

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
        assertEquals("Failure - ", true, game.wasCorrectlyAnswered());
    }
}

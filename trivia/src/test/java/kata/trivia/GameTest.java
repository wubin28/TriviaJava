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
            assertEquals("Failure - ", true, game.wasCorrectlyAnswered());
        }
        assertEquals("Failure - ", false, game.wasCorrectlyAnswered());
    }

    @Test
    public void WHEN_AddPlayersOneByOne_THEN_RollDiceInTheSameOrderButStartingFromTheSecondPlayer() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");

        // Then
        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Pat.", "Pat", game.getNameOfCurrentPlayer());

        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Sue.", "Sue", game.getNameOfCurrentPlayer());

        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Chet.", "Chet", game.getNameOfCurrentPlayer());

        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Pat.", "Pat", game.getNameOfCurrentPlayer());

        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Sue.", "Sue", game.getNameOfCurrentPlayer());

        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - the current player is actually Chet.", "Chet", game.getNameOfCurrentPlayer());

    }

    @Test
    public void WHEN_CurrentPlayerAnswersQuestionCorrectly_THEN_PresentAGoldCoin() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");

        // Then
        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - should win 1 gold coin.", 1, game.purses[game.currentPlayer]);
        game.roll(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - should win 2 gold coins.", 2, game.purses[game.currentPlayer]);
    }
}

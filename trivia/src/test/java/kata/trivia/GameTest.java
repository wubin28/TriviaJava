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
    public void WHEN_AddPlayersOneByOne_THEN_RollDiceInTheSameOrder() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");

        // Then
        game.processDiceRollingNumber(4);
        assertEquals("Failure - the current player is actually Chet.", "Chet", game.getNameOfCurrentPlayer());
        game.wasCorrectlyAnswered();

        game.processDiceRollingNumber(4);
        assertEquals("Failure - the current player is actually Pat.", "Pat", game.getNameOfCurrentPlayer());
        game.wasCorrectlyAnswered();

        game.processDiceRollingNumber(4);
        assertEquals("Failure - the current player is actually Sue.", "Sue", game.getNameOfCurrentPlayer());
        game.wasCorrectlyAnswered();

        game.processDiceRollingNumber(4);
        assertEquals("Failure - the current player is actually Chet.", "Chet", game.getNameOfCurrentPlayer());
        game.wasCorrectlyAnswered();
    }

    @Test
    public void WHEN_CurrentPlayerAnswersQuestionCorrectly_THEN_PresentAGoldCoin() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");

        // Then
        game.processDiceRollingNumber(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - should win 1 gold coin.", 1, game.getNumberOfGoldCoinsOfCurrentPlayer());
        game.processDiceRollingNumber(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - should win 2 gold coins.", 2, game.getNumberOfGoldCoinsOfCurrentPlayer());
    }

    @Test
    public void WHEN_AddOnePlayerAndAnswersQuestionWrong_THEN_SendToPenaltyBox() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");

        // Then
        game.processDiceRollingNumber(4);
        game.wrongAnswer();
        assertEquals("Failure - ", true, game.isCurrentPlayerInPenaltyBox());
    }

    @Test
    public void WHEN_AddTwoPlayersAndFirstPlayerAnswersQuestionWrong_THEN_SendToPenaltyBox() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");

        // Then
        game.processDiceRollingNumber(4);
        game.wrongAnswer();
        assertEquals("Failure - ", "Pat", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isPreviousPlayerOfCurrentPlayerInPenaltyBox());
    }

    @Test
    public void GIVEN_CurrentPlayerInPenaltyBox_WHEN_RollingDiceAndNumberIsDivisibleBy2_THEN_CannotGetOutOfPenaltyBox() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");

        // Then
        game.processDiceRollingNumber(4);
        game.wrongAnswer();
        assertEquals("Failure - ", "Pat", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isPreviousPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", false, game.isNextPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(4);
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isCurrentPlayerInPenaltyBox());
        assertEquals("Failure - ", false, game.isCurrentPlayerGettingOutOfPenaltyBox());
    }

    @Test
    public void GIVEN_CurrentPlayerInPenaltyBox_WHEN_RollingDiceAndNumberIsNotDivisibleBy2_THEN_GetOutOfPenaltyBox() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");

        // Then
        game.processDiceRollingNumber(4);
        game.wrongAnswer();
        assertEquals("Failure - ", "Pat", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isPreviousPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(4);
        game.wasCorrectlyAnswered();
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", false, game.isNextPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(5);
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isCurrentPlayerInPenaltyBox());
        assertEquals("Failure - ", true, game.isCurrentPlayerGettingOutOfPenaltyBox());
    }

    @Test
    public void WHEN_APlayerGotSixGoldCoins_THEN_GameIsOver() {
        // Given
        Game game = new Game();

        // When
        // Then
        game.addPlayer("Chet");

        for (int i = 0; i < 5; i++) {
            game.processDiceRollingNumber(4);
            assertEquals("Failure - ", true, game.wasCorrectlyAnswered());
        }
        assertEquals("Failure - ", false, game.wasCorrectlyAnswered());
    }

    @Test
    public void GIVEN_TwoPlayersInPenaltyBox_WHEN_ProcessQuestionAnswering_THEN_PlayerCannotAnswerQuestion() {
        // Given
        Game game = new Game();

        // When
        game.addPlayer("Chet");
        game.addPlayer("Pat");

        // Then
        game.processDiceRollingNumber(4);
        game.processQuestionAnswering(7);
        assertEquals("Failure - ", "Pat", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isPreviousPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(4);
        game.processQuestionAnswering(7);
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isNextPlayerOfCurrentPlayerInPenaltyBox());

        game.processDiceRollingNumber(4);
        game.processQuestionAnswering(7);
        assertEquals("Failure - ", "Chet", game.getNameOfCurrentPlayer());
        assertEquals("Failure - ", true, game.isNextPlayerOfCurrentPlayerInPenaltyBox());

    }
}

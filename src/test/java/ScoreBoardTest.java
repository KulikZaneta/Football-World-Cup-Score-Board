import org.example.Match;
import org.example.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    private Match match1;

    private Match match2;

    @BeforeEach
    public void setUp() {
        scoreBoard = new ScoreBoard();

        match1 = new Match("Mexico", "Canada");
        match2 = new Match("Spain", "Brazil");
    }

    @Test
    public void testStartGame() {
        scoreBoard.startGame(match1);

        List<Match> matches = scoreBoard.getSummary();
        assertEquals(1, matches.size(), "There should be 1 match in the scoreboard.");
        assertTrue(matches.contains(match1), "The match should be in the scoreboard.");
    }

    @Test
    public void testFinishGame() {
        scoreBoard.startGame(match1);

        scoreBoard.finishGame(match1);

        List<Match> matches = scoreBoard.getSummary();
        assertEquals(0, matches.size(), "There should be no matches in the scoreboard.");
    }

    @Test
    public void testUpdateScore() {
        scoreBoard.startGame(match1);

        scoreBoard.updateScore(match1, 3, 1);

        assertEquals(3, match1.getHomeScore(), "Home team score should be updated to 3.");
        assertEquals(1, match1.getAwayScore(), "Away team score should be updated to 1.");
    }

    @Test
    public void testGetSummarySortedByTotalScore() {
        scoreBoard.startGame(match1);
        scoreBoard.startGame(match2);

        scoreBoard.updateScore(match1, 2, 2);
        scoreBoard.updateScore(match2, 5, 1);

        List<Match> matches = scoreBoard.getSummary();

        assertEquals(match2, matches.get(0), "The match with the highest score should come first.");
        assertEquals(match1, matches.get(1), "The match with the lower score should come second.");
    }

    @Test
    public void testFinishGameNotInScoreboard() {
        assertThrows(IllegalStateException.class, () -> {
            scoreBoard.finishGame(match1);
        }, "An exception should be thrown when trying to finish a match not in the scoreboard.");
    }

    @Test
    public void testUpdateScoreWithNegativeValues() {
        scoreBoard.startGame(match1);

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(match1, -1, -2);
        }, "An exception should be thrown for negative scores.");
    }
}


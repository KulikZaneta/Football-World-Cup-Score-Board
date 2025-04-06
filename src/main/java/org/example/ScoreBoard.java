package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    public void startGame(Match match) {
        if (match == null) {
            throw new IllegalArgumentException("Match cannot be null.");
        }
        matches.add(match);
    }

    public void finishGame(Match match) {
        if (match == null) {
            throw new IllegalArgumentException("Match cannot be null.");
        }
        if (matches.contains(match)) {
            matches.remove(match);
        } else {
            throw new IllegalStateException("Match is not in the scoreboard.");
        }
    }

    public void updateScore(Match match, int homeScore, int awayScore) {
        if (match == null) {
            throw new IllegalArgumentException("Match cannot be null.");
        }
        match.updateScore(homeScore, awayScore);
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore).reversed())
                .collect(Collectors.toList());
    }
}


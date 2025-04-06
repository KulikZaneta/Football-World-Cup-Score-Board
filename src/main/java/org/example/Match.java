package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match {
   private final String homeTeam;

   private final String awayTeam;

   private int homeScore;

   private int awayScore;

   public Match(String homeTeam, String awayTeam) {
       if(homeTeam == null || awayTeam == null || homeTeam.equals(awayTeam)) {
           throw new IllegalArgumentException("homeTeam and awayTeam must not be null");
       }

       this.homeTeam = homeTeam;
       this.awayTeam = awayTeam;
       this.homeScore = 0;
       this.awayScore = 0;
   }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Scores must be non-negative integers.");
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return Objects.equals(homeTeam, match.homeTeam) &&
                Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %d - %d", homeTeam, awayTeam, homeScore, awayScore);
    }
}


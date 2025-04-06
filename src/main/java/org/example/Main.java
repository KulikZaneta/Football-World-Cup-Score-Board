package org.example;


public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match1 = new Match("Mexico", "Canada");
        Match match2 = new Match("Spain", "Brazil");
        Match match3 = new Match("Germany", "France");
        Match match4 = new Match("Uruguay", "Italy");
        Match match5 = new Match("Argentina", "Australia");

        scoreBoard.startGame(match1);
        scoreBoard.startGame(match2);
        scoreBoard.startGame(match3);
        scoreBoard.startGame(match4);
        scoreBoard.startGame(match5);

        scoreBoard.updateScore(match1, 0, 5);
        scoreBoard.updateScore(match2, 10, 2);
        scoreBoard.updateScore(match3, 2, 2);
        scoreBoard.updateScore(match4, 6, 6);
        scoreBoard.updateScore(match5, 3, 1);

        System.out.println("Match Summary:");
        scoreBoard.getSummary().forEach(System.out::println);
    }
}
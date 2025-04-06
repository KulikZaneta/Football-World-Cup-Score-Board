# ⚽ Football World Cup Score Board ⚽

## 📜 Description 📜

This project implements a simple **Football World Cup Score Board** that keeps track of live football matches and their scores. The application provides functionalities to:

1. **Start a game**: When a game starts, it records the home team, away team, and initial score (0-0). 🏟️
2. **Finish a game**: Removes a match from the scoreboard. 🏁
3. **Update score**: Allows updating the score for an ongoing match. ⚡
4. **Get a summary**: Returns a list of all games sorted by their total score. If two games have the same total score, they are sorted by the order in which they were added. 📊

## 🤖 Tech Stack 🤖
- ☕ **Java 17**
- 🛠️ **Maven**
- 🧪 **JUnit 5**

## 📦 Installation 📦

### 1. Clone the repository:
   `git clone https://github.com/KulikZaneta/Football-World-Cup-Score-Board.git`

### 2. Run the following command to build the project:
`mvn clean install`

## 🚀 How to Use 🚀

### 1. **Start a game 🏆**
To start a new game, create a Match object with the home and away teams, and use the ScoreBoard to start the game:

```java
ScoreBoard scoreBoard = new ScoreBoard();
Match match1 = new Match("Mexico", "Canada");
scoreBoard.startGame(match1);
```

This creates a match between Mexico and Canada with an initial score of 0-0. 🎮

### 2. **Update the score ⚽**
Once a game has started, you can update the score:

```java 
scoreBoard.updateScore(match1, 3, 1); // Mexico 3 - Canada 1
```

### 3. **Finish the game 🏁**
To finish a match and remove it from the scoreboard, use the finishGame method:

```java
scoreBoard.finishGame(match1);
```

### 4. **Get a summary 📈**
To get a sorted summary of all games based on their total score, use the getSummary method:

```java
List<Match> summary = scoreBoard.getSummary();
for (Match match : summary) {
System.out.println(match);
}
```

## 🧪  To run the tests: 🧪 
- After building the project, run the following command to execute the tests: `mvn test`
- Maven will run all the tests automatically. The test results will be displayed in the terminal.

## 📝 Assumptions 📝
The matches are stored in memory, so data will be lost once the application ends.

The scores must be non-negative integers.

The home and away teams must be distinct and not null.

## ⚡ Edge Cases ⚡
Attempting to finish a game that does not exist on the scoreboard will throw an exception.

Invalid score updates (negative scores) will throw an exception.

Games with identical scores are sorted by the order in which they were added.


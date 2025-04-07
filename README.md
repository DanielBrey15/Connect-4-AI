# Connect 4 AI
## Developing AI agents for the board game Connect 4

Overview of Connect 4: Players take turns choosing a column on a 6x7 board (6 rows, 7 columns) and placing a piece at the lowest empty space in that column. The winner is the player who is able to connect 4 pieces in a horizontal, vertical, or diagonal line.

The AI players in this game use a combination of minimax search and heuristics to determine the best move at any time.

We are using Spring Boot to run this Connect 4 application. Check out the java/com/connect-4/game-player directory's PlayGameController (in the controllers directory) and GamePlayer (in the service directory) to get started!

### Important files in the CoupEnvironment directory:
* PlayGameController.java: Contains GameController class which runs the complete game of Connect 4. Within a while loop, it accepts a player's action, updates the game, then passes the turn to the other player.
* MiniMax.java
* HeuristicScore.java

### Progress
The Connect 4 AI program is connected to a light Spring Boot application and runs properly. I would like to build more around Spring Boot including APIs that can create new AI players (based on things such as different heuristic scores).

## Next steps

### Strengthen move making model

* Apply machine learning to determine the best heuristic scores when calculating the best move.
* Calculate more statistics which can be used in heuristic scoring.

### Program structure

* Add new APIs to the application to include more functionality such as creating new player heuristics
* Add randomness to some extent so the same two players (based on player type and max depth)do not always complete the exact same game

### Code quality

* Update Player class so it does not extend the HeuristicScore service class
* Add additional comments where necessary
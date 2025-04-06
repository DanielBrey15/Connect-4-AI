# Connect 4 AI
## Developing AI agents for the board game Connect 4

Overview of Connect 4: Players take turns choosing a column on a 6x7 board (6 rows, 7 columns) and placing a piece at the lowest empty space in that column. The winner is the player who is able to connect 4 pieces in a horizontal, vertical, or diagonal line.

The AI players in this game use a combination of minimax search and heuristics to determine the best move at any time.

Check out Run.java to get started!

### Important files in the CoupEnvironment directory:
* Run.java: The main script that is called. It initializes the two player objects and a GameController oject, and then has that GameController run the game
* GameController.java: Contains GameController class which runs the complete game of Connect 4. Within a while loop, it accepts a player's action, updates the game, then passes the turn to the other player.
* MiniMax.java
* HeuristicScore.java

### Progress
The agents are able to play Connect 4, but their strategy and decision making can definitely be strengthened!

## Next steps

### Strengthen move making model

* Apply machine learning to determine the best heuristic scores when calculating the best move.

### Program structure

* Use Spring Boot to make an application that can show the game to the users.
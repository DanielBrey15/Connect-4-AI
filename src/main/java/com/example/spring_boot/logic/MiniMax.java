package com.example.spring_boot.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniMax extends Player{

  String id;
  int INF = 100000000;

  public MiniMax(int maxDepth, String stratID) {
    super(maxDepth);
    this.id = stratID;
  }

  public double MiniMaxSearch(Board currentBoard, boolean maxTurn, PlayerEnum player, int currentDepth, PlayerEnum origPlayer){
    // miniMaxSearch takes in a board and based on the board and the player/original player, it returns the score of board after completing necessary minimax search.
    // Current depth is how far the Minimax search has gone. Once it is equal to the max depth of the player, it calculates the best score based on heuristic.
    // If the current depth is less than the max depth of the player (set in Run.java), then it moves one level deeper on the Minimax tree.
    // If maxTurn is set to True, then it is the original player's turn and we want the maximum value. Otherwise, we want the minimum.

    GameStatusEnum gameStatus = currentBoard.gameStatus();

    if(gameStatus != GameStatusEnum.ONGOING) {
      return player == origPlayer ? INF : -1 * INF;
    }

    if(currentDepth == maxDepth){
      return CalculateScore(currentBoard.board, id, player);
    }

    PlayerEnum nextPlayer = Services.getNextPlayer(player);

    ArrayList<Board> Children = currentBoard.ExpandChildren(nextPlayer);
    // Children.get(0).printBoard();
    // Children.forEach((move) -> {
    //   move.printBoard();
    // });
    List<Double> scores = new ArrayList<Double>();
    for (Board move : Children) {
      double score = MiniMaxSearch(move, !maxTurn, nextPlayer, currentDepth+1, player);
      scores.add(score);
    }
    return maxTurn ? Collections.max(scores) : Collections.min(scores);
  }

  @Override
  protected double treeEval(Board board, PlayerEnum nextPlayer) {
    return MiniMaxSearch(board, true, nextPlayer, 1, nextPlayer);
  }
}

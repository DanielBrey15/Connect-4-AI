package com.connect_4.game_player.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.connect_4.game_player.model.PlayerEnum;

import java.util.Collections;

public abstract class Player extends HeuristicScore {
  protected final double PLAYER1_WIN_SCORE = 1;
  protected final double PLAYER2_WIN_SCORE = -1;
  protected final double DRAW_SCORE = 0;

  protected int maxDepth;

  public Player(int maxDepth) {
    this.maxDepth = maxDepth;
  }

  protected abstract double treeEval(Board board, PlayerEnum nextPlayer);

  public Board selectMove(Board board, PlayerEnum currentPlayer) {
    // Selects move based on minimax search and heuristic scoring, returns next board state 

    ArrayList<Board> moves = board.ExpandChildren(currentPlayer);

    Double[] hScores = evaluateMoves(currentPlayer, moves);
    List<Double> scoresList = new ArrayList<Double>();
    scoresList = Arrays.asList(hScores); // WEIRD

    double bestScore = Collections.max(scoresList); // WEIRD

    for(int i=0; i<scoresList.size(); i++){
      System.out.printf("Column %s score: %s\n", Integer.toString(i), scoresList.get(i));
    }
    int bestIndex = scoresList.indexOf(bestScore);
    System.out.printf("Player %s chooses column %s\n", currentPlayer, Integer.toString(bestIndex));
    Board moveToPlay = moves.get(bestIndex);

    return moveToPlay;
  }

  protected Double[] evaluateMoves(PlayerEnum currentPlayer, ArrayList<Board> moves) {
    // Evaluates actual move choices for the player (not within a minimax tree).
    // Returns array of scores for each potential move by running Minimax search on each option.
    Double[] scores = new Double[moves.size()];

    moves.forEach((move) -> {
      double score = treeEval(move, currentPlayer);
      scores[moves.indexOf(move)] = score;
    });
    return scores;
  }
}

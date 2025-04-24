package com.connect_4.game_player.service;

import java.util.ArrayList;

import com.connect_4.game_player.model.GameStatusEnum;
import com.connect_4.game_player.model.PlayerEnum;

public class GamePlayer {

  protected Board board;
  protected Player p1;
  protected Player p2;
  protected ArrayList<Board> boardCollection;
  protected Player activePlayer;

  public GamePlayer(Board board, Player p1, Player p2) {
    super();
    this.board = board;
    this.p1 = p1;
    this.p2 = p2;
    this.boardCollection = new ArrayList<Board>();
  }

  public ArrayList<Board> run() {
    PlayerEnum currentPlayer = null;
    GameStatusEnum gameStatus = board.gameStatus();
    while (gameStatus == GameStatusEnum.ONGOING) {
      System.out.print("Turn: " + currentPlayer + "\n");
      currentPlayer = updatePlayer();
      boardCollection.add(board);
      board.printBoard();

      Board selectedMove = activePlayer.selectMove(board, currentPlayer);

      board = selectedMove;

      gameStatus = board.gameStatus();
    }

    if (gameStatus == GameStatusEnum.PLAYER_WON) {
      System.out.println(activePlayer + " won!");
      board.printBoard();
    } else {
      System.out.println("Draw!");
    }
    return boardCollection;
  }

  private PlayerEnum updatePlayer() {
    if (activePlayer == p1)
      activePlayer = p2;
    else if (activePlayer == p2)
      activePlayer = p1;
    else
      activePlayer = p1;

    if (activePlayer == p1)
      return PlayerEnum.PLAYER1;
    else
      return PlayerEnum.PLAYER2;
  }
}

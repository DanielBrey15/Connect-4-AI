package com.example.spring_boot.logic;

public class GamePlayer {

  protected Board board;
  protected Player p1;
  protected Player p2;
  protected Player activePlayer;

  public GamePlayer(Board board, Player p1, Player p2) {
    super();
    this.board = board;
    this.p1 = p1;
    this.p2 = p2;
  }

  public void run() {
    PlayerEnum currentPlayer = null;
    GameStatusEnum gameStatus = board.gameStatus();
    while (gameStatus == GameStatusEnum.ONGOING) {
      System.out.print("Turn: " + currentPlayer + "\n");
      currentPlayer = updatePlayer();
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

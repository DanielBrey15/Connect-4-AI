package com.example.spring_boot.logic;

public class Services {
    public static PlayerEnum getNextPlayer(PlayerEnum player){
        return player == PlayerEnum.PLAYER1 ? PlayerEnum.PLAYER2 : PlayerEnum.PLAYER1;
    }
}

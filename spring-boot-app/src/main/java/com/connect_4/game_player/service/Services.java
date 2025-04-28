package com.connect_4.game_player.service;

import com.connect_4.game_player.model.PlayerEnum;

public class Services {
    public static PlayerEnum getNextPlayer(PlayerEnum player){
        return player == PlayerEnum.PLAYER1 ? PlayerEnum.PLAYER2 : PlayerEnum.PLAYER1;
    }
}

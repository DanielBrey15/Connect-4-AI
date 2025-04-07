package com.connect_4.game_player.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connect_4.game_player.model.PlayerTypeEnum;
import com.connect_4.game_player.service.Board;
import com.connect_4.game_player.service.GamePlayer;
import com.connect_4.game_player.service.MiniMax;
import com.connect_4.game_player.service.Player;

@RestController
public class PlayGameController {

    @GetMapping("/runGame")
    public String runGame(
        @RequestParam(value = "p1PlayerType", defaultValue = "OFFENSIVE") PlayerTypeEnum p1PlayerType,
        @RequestParam(value = "p1MaxDepth", defaultValue = "5") int p1MaxDepth,
        @RequestParam(value = "p2PlayerType", defaultValue = "DEFENSIVE") PlayerTypeEnum p2PlayerType,
        @RequestParam(value = "p2MaxDepth", defaultValue = "5") int p2MaxDepth
    ) {
        Board board = new Board(6, 7);
        Player p1 = new MiniMax(p1MaxDepth, p1PlayerType.toString());
        Player p2 = new MiniMax(p2MaxDepth, p2PlayerType.toString());

        GamePlayer gamePlayer = new GamePlayer(board, p1, p2);
        try{
            gamePlayer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p2PlayerType.toString();
    }
}

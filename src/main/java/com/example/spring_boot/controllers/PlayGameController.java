package com.example.spring_boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.logic.Board;
import com.example.spring_boot.logic.GamePlayer;
import com.example.spring_boot.logic.MiniMax;
import com.example.spring_boot.logic.Player;
import com.example.spring_boot.logic.PlayerTypeEnum;

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

package com.connect_4.game_player.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.connect_4.game_player.model.PlayerTypeEnum;
import com.connect_4.game_player.service.Board;
import com.connect_4.game_player.service.GamePlayer;
import com.connect_4.game_player.service.MiniMax;
import com.connect_4.game_player.service.Player;

@Controller
public class PlayGameController {
    @GetMapping("/runGame")
    public String runGame(
        Model model,
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
            var boardCollection = gamePlayer.run();
            model.addAttribute("strings", boardCollection.stream()
                .map(Board::renderHTMLBoard)
                .collect(Collectors.toCollection(ArrayList::new)));
                return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}

package com.example.clase9ws20232.controller;
import com.example.clase9ws20232.entity.Player;

import com.example.clase9ws20232.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/lsamerica")
    public List<Player> getPlayersAmerica() {
        return playerRepository.findByRegionOrderByMmrDesc("america");
    }

    @GetMapping("/lsasia")
    public List<Player> getPlayersAsia() {
        return playerRepository.findByRegionOrderByMmrDesc("asia");
    }
    @GetMapping("/lseuropa")
    public List<Player> getPlayersEuropa() {
        return playerRepository.findByRegionOrderByMmrDesc("europa");
    }
    @GetMapping("/lschina")
    public List<Player> getPlayersChina() {
        return playerRepository.findByRegionOrderByMmrDesc("china");
    }


    @PostMapping("/agregar")
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.reclacular(player);
    }
}


package com.teammanager.api.controller;

import com.teammanager.api.domain.Player;
import com.teammanager.api.model.PlayerDTO;
import com.teammanager.api.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody PlayerDTO playerDTO){
        Player player = playerService.createPlayer(playerDTO);
        if (player != null){
            return ResponseEntity.ok(player);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/getPlayerByTeamId")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamId(@RequestParam(name = "temId") Long teamId) {
        List<PlayerDTO> players = playerService.getPlayersByTeamId(teamId);

        if(players.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(players);
        }
    }

}

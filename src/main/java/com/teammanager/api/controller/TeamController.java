package com.teammanager.api.controller;

import com.teammanager.api.domain.Team;
import com.teammanager.api.model.TeamDTO;
import com.teammanager.api.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> getExample(@RequestBody TeamDTO teamDTO) {
        Team t = teamService.createTeam(teamDTO);
        if (t != null){
            return ResponseEntity.ok("GUARDADO EL EQUIPO "+ t.getName());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping(path = "/getTeamById")
    public ResponseEntity<?> getTeamById(@RequestParam(name = "id") Long id) {
        Team t = teamService.getTeamById(id);
        if (t != null){
            return ResponseEntity.ok(t);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}

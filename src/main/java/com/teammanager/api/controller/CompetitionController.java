package com.teammanager.api.controller;

import com.teammanager.api.domain.Competition;
import com.teammanager.api.model.CompetitionDTO;
import com.teammanager.api.service.interfaces.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/competition")
public class CompetitionController {


    @Autowired
    private CompetitionService competitionService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        Competition competition = competitionService.create(competitionDTO);
        if(competition != null){
            return ResponseEntity.ok(competition);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}

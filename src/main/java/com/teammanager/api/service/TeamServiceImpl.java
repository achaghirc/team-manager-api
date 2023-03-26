package com.teammanager.api.service;

import com.teammanager.api.domain.Team;
import com.teammanager.api.model.TeamDTO;
import com.teammanager.api.repository.TeamRepository;
import com.teammanager.api.service.interfaces.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Team createTeam(TeamDTO teamDTO) {
        return teamRepository.save(transformTeamDTOToTeam(teamDTO));
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.getTeamById(id);
    }


    public Team transformTeamDTOToTeam(TeamDTO teamDTO) {
        return modelMapper.map(teamDTO, Team.class);
    }
}

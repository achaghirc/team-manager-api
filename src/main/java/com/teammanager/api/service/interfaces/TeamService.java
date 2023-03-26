package com.teammanager.api.service.interfaces;

import com.teammanager.api.domain.Team;
import com.teammanager.api.model.TeamDTO;

public interface TeamService {

    Team createTeam(TeamDTO teamDTO);

    Team getTeamById(Long id);
}

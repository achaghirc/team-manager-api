package com.teammanager.api.service.interfaces;

import com.teammanager.api.domain.Player;
import com.teammanager.api.model.PlayerDTO;

import java.util.List;

public interface PlayerService {

    Player createPlayer(PlayerDTO playerDTO);

    List<PlayerDTO> getPlayersByTeamId(Long teamId);
}

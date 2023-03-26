package com.teammanager.api.service;

import com.teammanager.api.domain.Player;
import com.teammanager.api.domain.Team;
import com.teammanager.api.model.PlayerDTO;
import com.teammanager.api.repository.PlayerRepository;
import com.teammanager.api.service.interfaces.PlayerService;
import com.teammanager.api.service.interfaces.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamService teamService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        Player p = transformPlayerDTOToPlayer(playerDTO);
        Team t = teamService.getTeamById(playerDTO.getTeamId());
        p.setTeam(t);
        return playerRepository.save(p);
    }

    @Override
    public List<PlayerDTO> getPlayersByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId).stream().map(this::transformPlayerToPlayerDTO).collect(Collectors.toList());
    }

    private Player transformPlayerDTOToPlayer(PlayerDTO playerDTO) {
        return modelMapper.map(playerDTO, Player.class);
    }
    private PlayerDTO transformPlayerToPlayerDTO(Player player) {
        return modelMapper.map(player, PlayerDTO.class);
    }
}

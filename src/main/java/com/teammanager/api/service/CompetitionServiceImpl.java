package com.teammanager.api.service;

import com.teammanager.api.domain.Competition;
import com.teammanager.api.model.CompetitionDTO;
import com.teammanager.api.repository.CompetitionRepository;
import com.teammanager.api.service.interfaces.CompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    private CompetitionRepository competitionRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Competition create(CompetitionDTO competitionDTO) {
        return competitionRepository.save(competitionDTOToCompetition(competitionDTO));
    }


    public Competition competitionDTOToCompetition(CompetitionDTO competitionDTO) {
        return modelMapper.map(competitionDTO, Competition.class);
    }
}

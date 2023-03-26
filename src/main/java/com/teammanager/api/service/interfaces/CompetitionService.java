package com.teammanager.api.service.interfaces;

import com.teammanager.api.domain.Competition;
import com.teammanager.api.model.CompetitionDTO;

public interface CompetitionService {

    Competition create(CompetitionDTO competitionDTO);

}

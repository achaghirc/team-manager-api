package com.teammanager.api.repository;

import com.teammanager.api.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getTeamById(@Param(value = "id") Long id);
}

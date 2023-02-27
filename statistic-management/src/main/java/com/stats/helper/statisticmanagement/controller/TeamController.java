package com.stats.helper.statisticmanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stats.helper.statisticmanagement.domain.player.RankType;
import com.stats.helper.statisticmanagement.service.dota.opendota.OpenDotaPlayersService;
import com.stats.helper.statisticmanagement.service.dota.opendota.OpenDotaTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class TeamController
{

    private final OpenDotaPlayersService openDotaPlayersService;
    private final OpenDotaTeamService openDotaTeamService;

    public TeamController(final OpenDotaPlayersService openDotaPlayersService, final OpenDotaTeamService openDotaTeamService)
    {
        this.openDotaPlayersService = openDotaPlayersService;
        this.openDotaTeamService = openDotaTeamService;
    }

    @GetMapping
    public ResponseEntity getAllTeams() throws JsonProcessingException
    {
        openDotaTeamService.getAllDotaTeams();
        openDotaPlayersService.getAllPlayersByRankTier(RankType.DIVINE);
        return ResponseEntity.ok().build();
    }
}

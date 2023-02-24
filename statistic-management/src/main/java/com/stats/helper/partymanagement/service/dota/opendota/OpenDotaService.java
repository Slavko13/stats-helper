package com.stats.helper.partymanagement.service.dota.opendota;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stats.helper.partymanagement.domain.player.RankType;
import com.stats.helper.partymanagement.dto.openDota.OpenDotaPlayers;
import com.stats.helper.partymanagement.dto.openDota.OpenDotaTeamsDto;

import java.util.List;

public interface OpenDotaService
{

   List<OpenDotaTeamsDto> getAllDotaTeams() throws JsonProcessingException;
   OpenDotaTeamsDto getTeamById(final Long id) throws JsonProcessingException;

   List<OpenDotaPlayers> getAllPlayersByRankTier();
   List<OpenDotaPlayers> getAllPlayersByRankTier(final RankType rank);
   List<OpenDotaPlayers> getAllPlayersByTeam(final Long id);

   OpenDotaPlayers getPlayerBySteamId(final Long id);

}

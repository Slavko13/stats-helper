package com.stats.helper.statisticmanagement.service.dota.opendota;

import com.stats.helper.statisticmanagement.domain.player.RankType;
import com.stats.helper.statisticmanagement.dto.openDota.OpenDotaPlayers;

import java.util.List;


/**
 * interface for getting information about players from Open Dota
 *
 * @author Petrenko Viacheslav
 */
public interface OpenDotaPlayersService
{

    List<OpenDotaPlayers> getAllPlayersByRankTier();
    List<OpenDotaPlayers> getAllPlayersByRankTier(final RankType rank);
    List<OpenDotaPlayers> getAllPlayersByTeam(final Long id);

    OpenDotaPlayers getPlayerBySteamId(final Long id);

}

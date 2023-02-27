package com.stats.helper.statisticmanagement.service.dota.opendota;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stats.helper.statisticmanagement.dto.openDota.OpenDotaTeamsDto;

import java.util.List;


/**
 * interface for getting information about dota teams from Open Dota
 *
 * @author Petrenko Viacheslav
 */
public interface OpenDotaTeamService
{

   List<OpenDotaTeamsDto> getAllDotaTeams() throws JsonProcessingException;
   OpenDotaTeamsDto getTeamById(final Long id) throws JsonProcessingException;


}

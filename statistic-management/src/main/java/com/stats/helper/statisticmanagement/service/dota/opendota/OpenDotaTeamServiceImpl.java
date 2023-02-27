package com.stats.helper.statisticmanagement.service.dota.opendota;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stats.helper.statisticmanagement.dto.openDota.OpenDotaTeamsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for getting information about dota teams from Open Dota
 *
 * @author Petrenko Viacheslav
 */
public class OpenDotaTeamServiceImpl implements OpenDotaTeamService
{

    @Value("${opendota.api.url}")
    private String openDotaApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<OpenDotaTeamsDto> getAllDotaTeams() throws JsonProcessingException
    {
        String apiUrl = openDotaApiUrl + "teams";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        String responseBody = responseEntity.getBody();

        // Распарсим JSON-ответ с помощью библиотеки Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> teams = objectMapper.readValue(responseBody, new TypeReference<List<Map<String, Object>>>(){});

        return null;
    }

    @Override
    public OpenDotaTeamsDto getTeamById(final Long id) throws JsonProcessingException
    {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = openDotaApiUrl + "teams/{teamId}";
        Map<String, String> params = new HashMap<>();
        params.put("teamId", id.toString()); // ID команды
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class, params);
        String responseBody = responseEntity.getBody();

        // Распарсим JSON-ответ с помощью библиотеки Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> team = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>(){});
        return null;
    }
}

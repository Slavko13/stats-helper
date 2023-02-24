package com.stats.helper.partymanagement.service.dota.opendota;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stats.helper.partymanagement.domain.player.RankType;
import com.stats.helper.partymanagement.dto.openDota.OpenDotaPlayers;
import com.stats.helper.partymanagement.dto.openDota.OpenDotaTeamsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenDotaServiceImpl implements OpenDotaService
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

    @Override
    public List<OpenDotaPlayers> getAllPlayersByRankTier()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = openDotaApiUrl + "players";
        String response = restTemplate.getForObject(url, String.class);
        return null;
    }

    @Override
    public List<OpenDotaPlayers> getAllPlayersByTeam(final Long id)
    {

        RestTemplate restTemplate = new RestTemplate();
        String url = openDotaApiUrl + "teams/{team_id}/players";
        Map<String, String> params = new HashMap<>();
        params.put("team_id", id.toString()); // заменить на нужный team_id
        URI uri = UriComponentsBuilder.fromUriString(url).build(params);

        ResponseEntity<List<OpenDotaPlayers>> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OpenDotaPlayers>>() {}
        );

        List<OpenDotaPlayers> players = responseEntity.getBody();
        return null;
    }

    @Override
    public OpenDotaPlayers getPlayerBySteamId(final Long id)
    {

        RestTemplate restTemplate = new RestTemplate();
        String url = openDotaApiUrl + "players/{accountId}";
        String accountId = "123456789"; // здесь нужно указать айди игрока
        URI uri = URI.create(url.replace("{accountId}", accountId));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        String responseBody = response.getBody();
        return null;
    }

    @Override
    public List<OpenDotaPlayers> getAllPlayersByRankTier(final RankType rank)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.opendota.com/api/playersByRank?rank_tier={rank_tier}";
        Map<String, String> params = new HashMap<>();
        params.put("rank_tier", rank.toString());
        URI uri = UriComponentsBuilder.fromUriString(url).buildAndExpand(params).toUri();
        ResponseEntity<List<OpenDotaPlayers>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<OpenDotaPlayers>>() {});
        List<OpenDotaPlayers> players = responseEntity.getBody();
        return null;
    }
}

package com.stats.helper.statisticmanagement.service.dota.opendota;

import com.stats.helper.statisticmanagement.domain.player.RankType;
import com.stats.helper.statisticmanagement.dto.openDota.OpenDotaPlayers;
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

/**
 * Service for getting information about players from Open Dota
 *
 * @author Petrenko Viacheslav
 */
public class OpenDotaPlayersServiceImpl implements OpenDotaPlayersService
{

    @Value("${opendota.api.url}")
    private String openDotaApiUrl;
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
        String accountId = id.toString(); // здесь нужно указать айди игрока
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
        String url = openDotaApiUrl + "/playersByRank?rank_tier={rank_tier}";
        Map<String, String> params = new HashMap<>();
        params.put("rank_tier", rank.toString());
        URI uri = UriComponentsBuilder.fromUriString(url).buildAndExpand(params).toUri();
        ResponseEntity<List<OpenDotaPlayers>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<OpenDotaPlayers>>() {});
        List<OpenDotaPlayers> players = responseEntity.getBody();
        return null;
    }
}

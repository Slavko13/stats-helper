package com.stats.helper.statisticmanagement.dto.rest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto
{
    private Long id;

    private String name;

    private Long losses;

    private Long wins;

    private Long lastMatchTime;

    private String tag;

    private String logoUrl;

    private Long openDotaId;

}

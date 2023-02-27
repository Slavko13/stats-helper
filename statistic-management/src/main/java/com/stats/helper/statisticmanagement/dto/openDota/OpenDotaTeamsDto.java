package com.stats.helper.statisticmanagement.dto.openDota;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenDotaTeamsDto
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

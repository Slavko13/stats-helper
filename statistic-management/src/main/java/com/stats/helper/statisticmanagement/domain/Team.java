package com.stats.helper.statisticmanagement.domain;

import com.stats.helper.base.constants.StatsHelperInfo;
import lombok.Data;

import javax.persistence.*;


/**
 * Entity class about team information
 *
 * @author Petrenko Viacheslav
 */
@Entity
@Data
@Table(name = "team", schema = StatsHelperInfo.STATS_SCHEMA)
public class Team
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tag")
    private String tag;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "open_dota_id")
    private Long openDotaId;

}

package com.stats.helper.statisticmanagement.domain.player;

import com.stats.helper.base.constants.StatsHelperInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Entity class about players information
 *
 * @author Petrenko Viacheslav
 */
@Entity
@Data
@Table(name = "player", schema = StatsHelperInfo.STATS_SCHEMA)
public class Player
{
}

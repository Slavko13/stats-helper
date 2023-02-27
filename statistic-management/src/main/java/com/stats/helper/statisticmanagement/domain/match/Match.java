package com.stats.helper.statisticmanagement.domain.match;


import com.stats.helper.base.constants.StatsHelperInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Entity class about matches information as a rule  will save here custom matches created by user
 *
 * @author Petrenko Viacheslav
 */
@Entity
@Data
@Table(name = "match", schema = StatsHelperInfo.STATS_SCHEMA)
public class Match
{
}

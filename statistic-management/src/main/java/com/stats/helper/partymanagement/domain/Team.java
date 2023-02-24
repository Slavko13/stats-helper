package com.stats.helper.partymanagement.domain;

import com.stats.helper.base.constants.StatsHelperInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


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
}

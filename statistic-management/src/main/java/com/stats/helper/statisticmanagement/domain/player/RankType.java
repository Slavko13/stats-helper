package com.stats.helper.statisticmanagement.domain.player;

public enum RankType
{
    HERALD ("1"),
    GUARDIAN ("2"),
    CRUSADER ("3"),
    ARCHON ("4"),
    LEGEND ("5"),
    ANCIENT ("6"),
    DIVINE ("7"),
    IMMORTAL("8");

    private final String title;

    RankType(final String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }


    @Override
    public String toString()
    {
        return getTitle();
    }
}

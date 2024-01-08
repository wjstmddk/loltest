package org.example.lol_test.dto;

import jnr.posix.WString;
import lombok.Data;

@Data
public class GameDto {
    String gameId;
    int gameDuration;
    String gameVersion;
    String tier;
    String summonerId;
    int summonerLevel;
    String spell1Name;
    String spell2Name;
    String item0;
    String item1;
    String item2;
    String item3;
    String item4;
    String item5;
    String item6;
    String teamPosition;
    String teamId;
    boolean win;
    int kill;
    int death;
    int assists;
    int totalDamageDealtToChampions;
    int totalDamageTaken;
}

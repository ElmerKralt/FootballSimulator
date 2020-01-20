package com.example.footballsimulator.classes;

/**
 * Klasse Halfleague bevat de elementen noodzakelijk voor het aanmaken van een halve competitie.
 *
 * Auteur EK
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HalfLeague implements Tournament {

    int matchesPlayed;
    List<Match> schedule;
    List<Team> leagueTable;
    MatchProcessor processor = new MatchProcessor();
    Map<Match,MatchResult> matchResults= new HashMap();

    public HalfLeague(List<Team> leagueTable) {
        this.schedule = new ScheduleCreator(leagueTable).createSchedule();
        this.matchesPlayed = 0;
        this.leagueTable = leagueTable;
        Collections.sort(leagueTable, TeamComparators.NAME.reversed());
    }

    public void playMatch(Match match) {
        MatchResult result = processor.createResult(match);
        matchResults.put(match, result);
        processor.updateTeamStats(match, result);
        matchesPlayed++;
        Collections.sort(leagueTable, TeamComparators.SORTTABLE.reversed());
    }

    public void playAllMatches(List<Match> schedule) {
        for (int i = matchesPlayed; i < schedule.size(); i++) {
            playMatch(schedule.get(i));
            matchesPlayed++;
        }
    }

    public List<Match> getSchedule() {
        return schedule;
    }

    public List<Team> getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(List<Team> leagueTable) {
        this.leagueTable = leagueTable;
    }

    public Map<Match, MatchResult> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(Map<Match, MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}


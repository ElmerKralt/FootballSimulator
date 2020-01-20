package com.example.footballsimulator.classes;

/**
 * Klasse Team bevat de elementen noodzakelijk voor het aanmaken van een nieuw team.
 *
 * Auteur EK
 */

import java.util.HashMap;

public class Team implements Comparable<Team> {
    String name;
    int level;
    int points;
    int goalsScored;
    int goalsConceded;
    int goalDifference;
    HashMap<Team, HeadToHead> headToHeads; // Map met de onderlinge resultaten tegen andere teams
    int gamesPlayed;

    public Team (String name, int level) {
        this.name = name;
        this.level = level;
        this.points = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.goalDifference = 0;
        this.headToHeads = new HashMap<Team, HeadToHead>();
        this.gamesPlayed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public HashMap getHeadToHeads() {
        return headToHeads;
    }

    public void setHeadToHeads(HashMap headToHeads) {
        this.headToHeads = headToHeads;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String toString() {
        return this.name + " Pnt: " + this.points + "; DV: " + this.goalsScored + "; DT: " + this.goalsConceded + "; DS: " + this.goalDifference;
    }

    @Override // Mogelijk maken om teams te sorteren op basis van statistieken
    public int compareTo(Team o) {
        return TeamComparators.POINTS.compare(this, o);
    }
}



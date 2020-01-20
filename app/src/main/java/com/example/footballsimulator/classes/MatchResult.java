package com.example.footballsimulator.classes;

/**
 * Klasse MatchResult weerspiegelt de uitslagen van wedstrijden.
 *
 * Auteur EK
 */

public class MatchResult {
    int homeGoals;
    int awayGoals;

    public MatchResult(int homeGoals, int awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;

    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String toString() {
        return this.homeGoals + " - " + this.awayGoals;
    }
}


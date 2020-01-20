package com.example.footballsimulator.classes;

/**
 * TeamComparators bevat de comparators verantwoordelijk voor het sorteren van teams.
 *
 * Auteur EK
 */

import java.util.Comparator;

public class TeamComparators {

    public static Comparator<Team> POINTS = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {
            return a.getPoints() - b.getPoints();
        }
    };

    public static Comparator<Team> GAMESPLAYED = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {
            return a.getGamesPlayed() - b.getGamesPlayed();
        }
    };

    public static Comparator<Team> GOALDIFF = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {
            return a.getGoalDifference() - b.getGoalDifference();
        }
    };

    public static Comparator<Team> GOALSSCORED = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {
            return a.getGoalsScored() - b.getGoalsScored();
        }
    };

    public static Comparator<Team> HEADTOHEAD = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {
            int comparingValue;
            if (a.getHeadToHeads().containsKey(b)) { //Alleen sorteren op onderling resultaat als teams al tegen elkaar hebben gespeeld
                HeadToHead headToHead = (HeadToHead) a.getHeadToHeads().get(b);
                comparingValue = headToHead.getPoints(); // Eerst sorteren op tegen elkaar behaalde punten
                if (comparingValue == 0) {
                    comparingValue = headToHead.getGoalDifference(); // Als dat gelijk is, dan kijken naar onderling doelsaldo
                }
            } else {
                comparingValue = 0;
            }

            return comparingValue;

        }
    };

    public static Comparator<Team> NAME = new Comparator<Team>() {
        @Override
        public int compare(Team a, Team b) {// Sorteert als enige van de comparators normaal 'ascending'.
            return (a.getName().compareTo(b.getName())) * -1; //*-1 om deze net als de andere ook 'descending' te maken
        }
    };

    //Sorteer stand op basis van alle teamstatistieken
    public static Comparator<Team> SORTTABLE = POINTS.thenComparing(GAMESPLAYED).thenComparing(GOALDIFF).thenComparing(GOALSSCORED).thenComparing(HEADTOHEAD.thenComparing(NAME));
}


package com.example.footballsimulator.classes;

/**
 * Klasse MatchProcessor bevat methodes om een uitslag te genereren en de statistieken van teams te verwerken.
 *
 * Auteur EK
 */

public class MatchProcessor {

    public MatchResult createResult(Match match) {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();
        int levelDiff = 0;
        int homeGoals = 0;
        int awayGoals = 0;

        levelDiff = homeTeam.getLevel() - awayTeam.getLevel(); //Definieer niveauverschil tussen teams
        if (levelDiff > 3) {
            levelDiff = 3;
        } else if (levelDiff < -3) {
            levelDiff = -3;
        }

        switch(levelDiff) { //Genereer thuis- en uitgoals op basis van niveauverschil
            case -3:
                homeGoals = (int) (4 * (Math.random()*Math.random()));
                awayGoals = (int) (9.5 * (Math.random()*Math.random()));
                break;
            case -2:
                homeGoals = (int) (4.75 * (Math.random()*Math.random()));
                awayGoals = (int) (8.75 * (Math.random()*Math.random()));
                break;
            case -1:
                homeGoals = (int) (6 * (Math.random()*Math.random()));
                awayGoals = (int) (8 * (Math.random()*Math.random()));
                break;
            case 0:
                homeGoals = (int) (7 * (Math.random()*Math.random()));
                awayGoals = (int) (7 * (Math.random()*Math.random()));
                break;
            case 1:
                homeGoals = (int) (8 * (Math.random()*Math.random()));
                awayGoals = (int) (6 * (Math.random()*Math.random()));
                break;
            case 2:
                homeGoals = (int) (8.75 * (Math.random()*Math.random()));
                awayGoals = (int) (4.75 * (Math.random()*Math.random()));
                break;
            case 3:
                homeGoals = (int) (9.5 * (Math.random()*Math.random()));
                awayGoals = (int) (4 * (Math.random()*Math.random()));
                break;
        }
        return new MatchResult(homeGoals, awayGoals);
    }

    public void updateTeamStats(Match match, MatchResult result) {
        updateHomeTeamStats(match, result);
        updateAwayTeamStats(match, result);
    }

    private void updateHomeTeamStats(Match match, MatchResult result) {
        Team homeTeam = match.getHomeTeam();
        int points = 0;
        int goalsScored = result.getHomeGoals();
        int goalsConceded = result.getAwayGoals();
        int goalDifference = goalsScored - goalsConceded;
        if (goalDifference > 0) { //Bereken punten a.d.h.v. doelsaldo;
            points = 3; // positief doelsaldo = 3 punten
        } else if (goalDifference < 0) {
            points = 0; // negatief doelsaldo = 0 punten
        } else {
            points = 1; // gelijkspel = 1 punt
        }
        updatePoints(homeTeam, points);
        updateGoalsScored(homeTeam, goalsScored);
        updateGoalsConceded(homeTeam, goalsConceded);
        updateGoalDifference(homeTeam, goalDifference);
        HeadToHead headToHead = new HeadToHead(points, goalDifference);
        updateHeadToHeads(homeTeam, match.getAwayTeam(), headToHead); //toevoegen van onderling resultaat aan map
        updateGamesPlayed(homeTeam);

    }

    private void updateAwayTeamStats(Match match, MatchResult result) {
        Team awayTeam = match.getAwayTeam();
        int points = 0;
        int goalsScored = result.getAwayGoals();
        int goalsConceded = result.getHomeGoals();
        int goalDifference = goalsScored - goalsConceded;
        if (goalDifference > 0) {
            points = 3;
        } else if (goalDifference < 0) {
            points = 0;
        } else {
            points = 1;
        }
        updatePoints(awayTeam, points);
        updateGoalsScored(awayTeam, goalsScored);
        updateGoalsConceded(awayTeam, goalsConceded);
        updateGoalDifference(awayTeam, goalDifference);
        HeadToHead headToHead = new HeadToHead(points, goalDifference);
        updateHeadToHeads(awayTeam, match.getHomeTeam(), headToHead); //toevoegen van onderling resultaat aan map
        updateGamesPlayed(awayTeam);
    }

    private void updatePoints(Team team, int points) {
        int total = team.getPoints() + points;
        team.setPoints(total);
    }

    private void updateGoalsScored(Team team, int goalsScored) {
        int total = team.getGoalsScored() + goalsScored;
        team.setGoalsScored(total);
    }

    private void updateGoalsConceded(Team team, int goalsConceded) {
        int total = team.getGoalsConceded() + goalsConceded;
        team.setGoalsConceded(total);
    }

    private void updateGoalDifference(Team team, int goalDifference) {
        int total = team.getGoalDifference() + goalDifference;
        team.setGoalDifference(total);
    }

    private void updateHeadToHeads(Team a, Team b, HeadToHead headToHead) {
        if (a.getHeadToHeads().containsKey(b)) { // check of er al een onderling resultaat bekend is. Zo ja, statistieken updaten
            HeadToHead old = (HeadToHead) a.getHeadToHeads().get(b);
            int points = old.getPoints() + headToHead.getPoints();
            int goalDiff = old.getGoalDifference() + headToHead.getGoalDifference();
            HeadToHead updated = new HeadToHead(points, goalDiff);
            a.getHeadToHeads().replace(b, updated);
        } else {
            a.getHeadToHeads().put(b, headToHead); //eerste keer dat teams elkaar getroffen hebben
        }
    }

    private void updateGamesPlayed(Team team) {
        team.setGamesPlayed(team.getGamesPlayed() + 1);

    }

}


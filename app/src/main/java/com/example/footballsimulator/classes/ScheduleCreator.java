package com.example.footballsimulator.classes;

/**
 * Klasse ScheduleCreator is verantwoordelijk voor het genereren van een wedstrijdschema.
 *
 * Auteur EK
 */

import java.util.ArrayList;
import java.util.List;

public class ScheduleCreator {

    List<Team> teams;

    public ScheduleCreator(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> createSchedule(){
        List<Match> schedule = new ArrayList<>();
        switch(this.teams.size()) { //Aanmaken wedstrijdschema op basis van aantal teams
            case 4: //Hardcoded. Indien mogelijk algoritme toevoegen op basis waarvan wedstrijdschema kan worden gemaakt.
                schedule.add(new Match(teams.get(0),teams.get(1)));
                schedule.add(new Match(teams.get(2),teams.get(3)));
                schedule.add(new Match(teams.get(1),teams.get(2)));
                schedule.add(new Match(teams.get(3),teams.get(0)));
                schedule.add(new Match(teams.get(0),teams.get(2)));
                schedule.add(new Match(teams.get(1),teams.get(3)));
                break;
        }

        return schedule;

    }
}


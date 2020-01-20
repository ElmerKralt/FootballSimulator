package com.example.footballsimulator;

/**
 * DisplaySchedule is de tweede pagina van de app, waarop wedstrijdschema, uitslagen en stand getoond worden.
 *
 * Auteur EK
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.footballsimulator.classes.*;

import java.util.ArrayList;
import java.util.List;

public class DisplaySchedule extends AppCompatActivity {

    public HalfLeague poule = createLeague();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule);
        createSchedule();
        playAllMatches();
        fillSchedule(poule);
        fillLeaguetableSimple();
        //createLeaguetable();
        //fillLeaguetable();



    }

    private void fillLeaguetableSimple(){ // Eenvoudige (gesorteerde) weergave van teamstatistieken
        TableLayout leaguetable = (TableLayout) findViewById(R.id.leaguetable);
        for (int i=0; i < poule.getLeagueTable().size(); i++) {
            TableRow team = new TableRow(this);
            TextView teaminfo = new TextView(this);
            teaminfo.setText(poule.getLeagueTable().get(i).toString());
            team.addView(teaminfo);
            leaguetable.addView(team);
        }
    }

    private void fillLeaguetable() { // Het tonen van de stand

        TableLayout leaguetable = (TableLayout) findViewById(R.id.leaguetable);
        for (int i=0; i < poule.getLeagueTable().size(); i++) {
            TableRow team = new TableRow(this);
            TextView position = new TextView(this);
            position.setText((i+1));
            TextView name = new TextView(this);
            name.setText(poule.getLeagueTable().get(i).getName());
            TextView points = new TextView(this);
            points.setText(poule.getLeagueTable().get(i).getPoints());
            TextView goalsScored = new TextView(this);
            goalsScored.setText(poule.getLeagueTable().get(i).getGoalsScored());
            TextView goalsConceded = new TextView(this);
            goalsConceded.setText(poule.getLeagueTable().get(i).getGoalsConceded());
            TextView goalDiff = new TextView(this);
            goalDiff.setText(poule.getLeagueTable().get(i).getGoalDifference());
            team.addView(position);
            team.addView(name);
            team.addView(points);
            team.addView(goalsScored);
            team.addView(goalsConceded);
            team.addView(goalDiff);
            leaguetable.addView(team);
        }
    }

    private void createLeaguetable() { // Aanmaken basistabel voor stand
        TableLayout leaguetable = (TableLayout) findViewById(R.id.leaguetable);
        leaguetable.setStretchAllColumns(true);
        leaguetable.bringToFront();
        TableRow head = new TableRow(this);
        TextView c1 = new TextView(this);
        c1.setText("");
        TextView c2 = new TextView(this);
        c2.setText("Team");
        TextView c3 = new TextView(this);
        c3.setText("Pnt");
        TextView c4 = new TextView(this);
        c4.setText("DV");
        TextView c5 = new TextView(this);
        c5.setText("DT");
        TextView c6 = new TextView(this);
        c6.setText("Saldo");
        head.addView(c1);
        head.addView(c2);
        head.addView(c3);
        head.addView(c4);
        head.addView(c5);
        head.addView(c6);
        leaguetable.addView(head);
        TableRow blank = new TableRow(this);
        TextView blankText = new TextView(this);
        blank.addView(blankText);
        leaguetable.addView(blank);
    }

    private void playAllMatches() {
        poule.playAllMatches(poule.getSchedule());
    }

    private void playNextMatch() {
        poule.playMatch(poule.getSchedule().get(poule.getMatchesPlayed()));
    }

    public void createSchedule() { // aanmaken tabel voor wedstrijdschema
            TableLayout schedule = (TableLayout) findViewById(R.id.schedule);
            schedule.setStretchAllColumns(true);
            schedule.bringToFront();
            TableRow head = new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText("Thuis");
            TextView c2 = new TextView(this);
            c2.setText("Uit");
            TextView c3 = new TextView(this);
            c3.setText("Uitslag");
            head.addView(c1);
            head.addView(c2);
            head.addView(c3);
            schedule.addView(head);
            TableRow blank = new TableRow(this);
            TextView blankText = new TextView(this);
            blank.addView(blankText);
            schedule.addView(blank);
        }

        public HalfLeague createLeague() { //hardcoded voorbeeld van een halve competitie
            Team nl = new Team("Nederland", 4);
            Team oek = new Team("Oekraïne", 3);
            Team oost = new Team("Oostenrijk", 3);
            Team rom = new Team("Roemenië", 2);

            List<Team> leagueTeams = new ArrayList<Team>();
            leagueTeams.add(rom);
            leagueTeams.add(oek);
            leagueTeams.add(nl);
            leagueTeams.add(oost);

            HalfLeague poule = new HalfLeague(leagueTeams);

            return poule;
        }

        public void fillSchedule(HalfLeague poule){ // Vullen van het wedstrijdschema in tabel
            TableLayout schedule = (TableLayout) findViewById(R.id.schedule);
            for (int i=0; i<poule.getSchedule().size(); i++){
            TableRow match =  new TableRow(this);
            TextView homeTeam = new TextView(this);
            homeTeam.setText(poule.getSchedule().get(i).getHomeTeam().getName());
            TextView awayTeam = new TextView(this);
            awayTeam.setText(poule.getSchedule().get(i).getAwayTeam().getName());
            TextView result = new TextView(this);
            result.setText(poule.getMatchResults().get(poule.getSchedule().get(i)).toString());
            match.addView(homeTeam);
            match.addView(awayTeam);
            match.addView(result);
            schedule.addView(match);
        }
    }
}

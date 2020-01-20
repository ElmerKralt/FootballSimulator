package com.example.footballsimulator.classes;

/**
 * Interface bevat de methodes noodzakelijk voor het spelen van verschillende toernooiformats.
 *
 * Auteur EK
 */

import java.util.List;

public interface Tournament {

    public void playMatch(Match match);
    public void playAllMatches(List<Match> schedule);
}

package com.example.footballsimulator.classes;

public class HeadToHead {
    int points;
    int goalDifference;

    public HeadToHead(int points, int goalDifference) {
        this.points = points;
        this.goalDifference = goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }
}


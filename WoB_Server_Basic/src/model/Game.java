package model;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> players;
    private float time;
    private boolean humanWin;

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean isHumanWin() {
        return humanWin;
    }

    public void setHumanWin(boolean humanWin) {
        this.humanWin = humanWin;
    }
}

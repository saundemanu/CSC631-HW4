package model;

import java.util.ArrayList;

public class Lobby {
    private int size;
    private ArrayList<Integer> players = new ArrayList();
    private String password;


    public Lobby(String password) {
        this.password = password;
    }

    public Lobby(int size, String password) {
        this.size = size;
        this.password = password;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Integer> getPlayers() {
        return this.players;
    }

    public void addPlayer(int player_id) {
        this.players.add(player_id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

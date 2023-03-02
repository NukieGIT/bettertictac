package nuk.logic;

import nuk.util.Vector2D;

import java.util.Arrays;

public class GameSettings {
    private Vector2D size;
    private Figure[] players;
    private int toWin;

    public GameSettings(Vector2D size, Figure[] players, int toWin) {
        this.size = size;
        this.players = players;
        this.toWin = toWin;
    }

    public Vector2D getSize() {
        return size;
    }

    public Figure[] getPlayers() {
        return players;
    }

    public int getToWin() {
        return toWin;
    }

    @Override
    public String toString() {
        return "GameSettings{" +
                "size=" + size +
                ", players=" + Arrays.toString(players) +
                ", toWin=" + toWin +
                '}';
    }
}

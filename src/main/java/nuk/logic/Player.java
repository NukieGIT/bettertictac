package nuk.logic;

import java.awt.*;

public class Player {
    private String player;
    private Color clr;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    public Player(String player, Color clr) {
        this.player = player;
        this.clr = clr;
    }

}

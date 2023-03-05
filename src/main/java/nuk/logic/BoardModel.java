package nuk.logic;

import nuk.events.Event;
import nuk.events.EventManager;
import nuk.util.Vector2D;

import java.util.HashMap;

public class BoardModel {
    private HashMap<Vector2D, Player> map = new HashMap<>();
    private GameSettings settings;
    private WinChecker  winChecker;
    private EventManager<Player> onWin;

    public BoardModel() {
        settings = SettingsManager.getInstance().getSettings();
        onWin = new EventManager<>();
        winChecker = new WinChecker();
    }

    private void checkForWinner() {
        Player winner = winChecker.WinnerCheck(map);
        if (winner != null) onWin.invoke(this, winner);
    }

    public HashMap<Vector2D, Player> getMap() {
        return map;
    }

    public Player getPlayerAtPos(Vector2D pos) {
        return map.get(pos);
    }

    public void setMap(HashMap<Vector2D, Player> map) {
        this.map = map;
    }

    public void setPosition(Vector2D pos, Player player) {
        map.put(pos, player);
        checkForWinner();
    }

    public void removePosition(Vector2D pos) {
        map.remove(pos);
    }

    public Event<Player> getOnWinEvent() {
        return onWin.getEvent();
    }

}

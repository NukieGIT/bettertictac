package nuk.logic;

import nuk.events.Event;
import nuk.events.EventManager;
import nuk.util.Vector2D;

import java.util.HashMap;

public class BoardModel {
    private HashMap<Vector2D, Figure> map = new HashMap<>();
    private GameSettings settings;
    private WinChecker  winChecker;
    private EventManager<Figure> onWin;

    public BoardModel() {
        settings = SettingsManager.getInstance().getSettings();
        onWin = new EventManager<>();
        winChecker = new WinChecker();
    }

    private void checkForWinner() {
        Figure winner = winChecker.WinnerCheck(map);
        if (winner != null) onWin.invoke(this, winner);
    }

    public HashMap<Vector2D, Figure> getMap() {
        return map;
    }

    public void setMap(HashMap<Vector2D, Figure> map) {
        this.map = map;
    }

    public void setPosition(Vector2D pos, Figure figure) {
        map.put(pos, figure);
        checkForWinner();
    }

    public void removePosition(Vector2D pos) {
        map.remove(pos);
    }

    public Event<Figure> getOnWinEvent() {
        return onWin.getEvent();
    }

}

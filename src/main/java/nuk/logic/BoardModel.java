package nuk.logic;

import nuk.events.Event;
import nuk.events.EventArgs;
import nuk.events.EventManager;
import nuk.util.Vector2D;

import java.util.HashMap;

public class BoardModel {
    private HashMap<Vector2D, Player> map = new HashMap<>();
    private EventManager<EventArgs> onChange;

    public BoardModel() {
        onChange = new EventManager<>();
    }

    public HashMap<Vector2D, Player> getMap() {
        return map;
    }

    public Player getPlayerAtPos(Vector2D pos) {
        return map.get(pos);
    }

    public void setMap(HashMap<Vector2D, Player> map) {
        this.map = map;
        onChange.invoke(this, EventArgs.EMPTY);
    }

    public void setPosition(Vector2D pos, Player player) {
        map.put(pos, player);
        onChange.invoke(this, EventArgs.EMPTY);
    }

    public void removePosition(Vector2D pos) {
        map.remove(pos);
        onChange.invoke(this, EventArgs.EMPTY);
    }

    public Event<EventArgs> getOnChangeEvent() {
        return onChange.getEvent();
    }

}

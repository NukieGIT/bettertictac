package nuk.ui;

import nuk.events.Event;
import nuk.logic.Player;
import nuk.util.Vector2D;

public interface IBoardView {
    void show();
    void hide();

    Event<Vector2D> getNewPositionEvent();
    void handleWinEvent(Player player);

}

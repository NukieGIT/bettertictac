package nuk.ui;

import nuk.events.Event;
import nuk.events.EventArg;
import nuk.logic.Player;
import nuk.util.Vector2D;

public interface IBoardView {
    void show();
    void hide();

    void update();

    Event<EventArg<Vector2D>> getNewPositionEvent();
    void handleWinEvent(Player player);

}

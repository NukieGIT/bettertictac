package nuk.events;

import java.util.ArrayList;
import java.util.Iterator;

public class EventManager<T extends EventArgs> {
    private ArrayList<IEventHandler<T>> handlers;
    private Event<T> event;

    public EventManager() {
        handlers = new ArrayList<>();
        event = new Event<>(this);
    }

    void addHandler(IEventHandler<T> handler) {
        synchronized (event) {
            handlers.add(handler);
        }
    }

    void removeHandler(IEventHandler<T> handler) {
        synchronized (event) {
            for (Iterator<IEventHandler<T>> it = handlers.iterator(); it.hasNext();) {
                IEventHandler<T> ref = it.next();

                if (ref == null || handler == ref) {
                    it.remove();
                }
            }
        }
    }

    public void invoke(Object source, T args) {
        ArrayList<IEventHandler<T>> targets = new ArrayList<>();

        synchronized (event) {
            for (Iterator<IEventHandler<T>> it = handlers.iterator(); it.hasNext(); ) {
                IEventHandler<T> ref = it.next();

                if (ref == null) {
                    it.remove();
                } else {
                    targets.add(ref);
                }

            }
        }

        for (IEventHandler<T> handler : targets) {
            handler.handleEvent(source, args);
        }
    }

    public void clearHandlers() {
        synchronized (event) {
            handlers.clear();
        }
    }

    public Event<T> getEvent() {
        return event;
    }

}

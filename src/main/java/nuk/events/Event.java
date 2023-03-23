package nuk.events;

public class Event<T extends EventArgs> {
    private EventManager<T> parent;

    protected Event(EventManager<T> parent) {
        this.parent = parent;
    }

    public void subscribe(IEventHandler<T> handler) {
        parent.addHandler(handler);
    }

    public void unsubscribe(IEventHandler<T> handler) {
        parent.removeHandler(handler);
    }
}

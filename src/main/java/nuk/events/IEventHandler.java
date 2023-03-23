package nuk.events;

@FunctionalInterface
public interface IEventHandler<T extends EventArgs> {
    void handleEvent(Object source, T args);
}

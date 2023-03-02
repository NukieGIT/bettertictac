package nuk.events;

@FunctionalInterface
public interface IEventHandler<T> {
    void handleEvent(Object source, T args);
}

package nuk.events;

public class EventArg<T> extends EventArgs {
    private T value;

    public EventArg(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public interface Container<T> {
    void setValue(T value);

    T getValue();
}
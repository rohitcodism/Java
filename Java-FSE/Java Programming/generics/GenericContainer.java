public class GenericContainer<T> implements Container<T>{
    private T value;

    private GenericContainer(){
        System.out.println("New Generic Container Created.");
    }

    public static <T> GenericContainer<T> createGenericContainer(){
        return new GenericContainer<T>();
    }

    @Override
    public void setValue(T value) {
        this.value=value;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
public class Box<T> {
    private T value;

    void setValue(T val){
        this.value = val;
    }

    T getValue(){
        return this.value;
    }
}

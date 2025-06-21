interface InnerBox {
    void boxify();
}

public class Box<T extends Number & InnerBox> {
    private T value;

    void setValue(T val){
        this.value = val;
    }

    T getValue(){
        return this.value;
    }
}

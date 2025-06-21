enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b){
        switch (this) {
            case ADD:
                return a.doubleValue()+b.doubleValue();
            case SUBTRACT:
                return a.doubleValue()-b.doubleValue();
            case MULTIPLY:
                return a.doubleValue()*b.doubleValue();
            case DIVIDE:
                return a.doubleValue()/b.doubleValue();
            default:
                return (double) 0;
        }
    }
}

public class MagicEnum {
    public static void main(String[] args) {
        double res1 = Operation.ADD.apply(18786,65647);
        System.out.println("Result: "+res1);
    }
}

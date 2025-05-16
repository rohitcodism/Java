public class Cat implements Animal{
    @Override
    public void eat(){
        System.out.println("The cat is eating");
    }

    @Override
    public void roar(){
        System.out.println("The cat is roaring.");
    }
}

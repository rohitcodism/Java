public class DebitCard implements PaymentMethod{
    @Override
    public void pay(int totalAmount){
        System.out.println(totalAmount + " is paid using Debit Card.");
    }
}
class ShoppingCart{
    private int totalAmount;

    ShoppingCart(int totalAmount){
        this.totalAmount = totalAmount;
    }

    public void processPayment(PaymentMethod method){
        method.pay(totalAmount);
    }
}
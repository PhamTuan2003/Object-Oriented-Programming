package behavioral.strategy;

public class PayInCashStrategy implements PaymentStrategy{
    @Override
    public void pay(double total) {
        System.out.println("Thanh toán trực tiếp: " + total);
    }
}

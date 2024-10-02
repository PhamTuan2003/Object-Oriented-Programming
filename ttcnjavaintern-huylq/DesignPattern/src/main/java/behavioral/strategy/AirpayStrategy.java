package behavioral.strategy;

public class AirpayStrategy implements PaymentStrategy{
    @Override
    public void pay(double total) {
        System.out.println("Thanh toán qua Airpay: " + total);
    }
}

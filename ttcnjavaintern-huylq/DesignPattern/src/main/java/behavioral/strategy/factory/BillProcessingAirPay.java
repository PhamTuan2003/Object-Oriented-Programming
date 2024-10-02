package behavioral.strategy.factory;

import behavioral.strategy.AirpayStrategy;
import behavioral.strategy.PaymentStrategy;

public class BillProcessingAirPay extends BillProcessing{
    @Override
    public PaymentStrategy processPayment() {
        return new AirpayStrategy();
    }
}

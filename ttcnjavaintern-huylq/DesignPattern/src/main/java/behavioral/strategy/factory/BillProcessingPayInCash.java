package behavioral.strategy.factory;

import behavioral.strategy.PayInCashStrategy;
import behavioral.strategy.PaymentStrategy;

public class BillProcessingPayInCash extends BillProcessing{
    @Override
    public PaymentStrategy processPayment() {
        return new PayInCashStrategy();
    }
}

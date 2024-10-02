package behavioral.strategy.factory;

import behavioral.strategy.PaymentStrategy;

public abstract class BillProcessing {

    public void processCart() {

    }

    public abstract PaymentStrategy processPayment();

    public void processShipment() {

    }

    public void processReceipt() {

    }
}

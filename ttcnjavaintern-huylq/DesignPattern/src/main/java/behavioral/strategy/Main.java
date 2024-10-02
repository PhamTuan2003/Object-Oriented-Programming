package behavioral.strategy;

import behavioral.strategy.factory.BillProcessing;
import behavioral.strategy.factory.BillProcessingAirPay;
import behavioral.strategy.factory.BillProcessingPayInCash;

public class Main {
    public static void main(String[] args) {
        BillProcessing billProcessing = selectPayMethod("airPay");
        billProcessing.processPayment().pay(10000D);
    }

    private static BillProcessing selectPayMethod(String payMethod) {
        switch (payMethod) {
            case "payInCash":
                return new BillProcessingPayInCash();
            case "airPay":
                return new BillProcessingAirPay();
            default:
                return new BillProcessingPayInCash();
        }
    }
}

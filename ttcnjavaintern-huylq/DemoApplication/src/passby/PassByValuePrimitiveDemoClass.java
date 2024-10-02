package passby;

public class PassByValuePrimitiveDemoClass {

    public static void main(String[] args) {
        Float balance = 100_000F;
        takeOut(balance);
        System.out.println("Balance: " + balance);
    }

    public static void takeOut(Float balance) {
        balance -= 50_000F;
    }

}

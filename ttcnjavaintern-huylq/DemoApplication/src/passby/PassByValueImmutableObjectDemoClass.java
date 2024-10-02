package passby;

public class PassByValueImmutableObjectDemoClass {
    public static void main(String[] args) {
        String companyName = new String("Viettel Digital");
        applyService(companyName);
        System.out.println(companyName);
    }

    private static void applyService(String companyName) {
        companyName.concat("Service");
    }
}

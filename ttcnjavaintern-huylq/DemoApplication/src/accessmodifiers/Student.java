package accessmodifiers;

public class Student extends Human {
    public void someMethod() {

        System.out.println("Private: " + "Can't access.");
        System.out.println("Protected: " + this.name);
        System.out.println("Default: " + this.age);
        System.out.println("Public: " + this.kind);
    }
}

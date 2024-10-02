package accessmodifiers;

public class ClassPresident extends Student {
    public void method() {
        System.out.println("Protected: " + this.name);
        System.out.println("Default: " + this.age);
        System.out.println("Public: " + this.kind);
    }
}

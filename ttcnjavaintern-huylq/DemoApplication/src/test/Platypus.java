package test;

public class Platypus extends Mammal {
    public int name;
    public Platypus() {
        super(5);
        System.out.println("Platypus");
    }

    @Override
    public void print() {
        System.out.println("Platypus");
    }

    public static void main(String[] args) {
        Mammal m = (Mammal) new Platypus();
        m.print();
    }
}

class A {
    private B b;

    public A(B b) {
        this.b = b;
    }
}

class B {}

public class ConstructorInjection {
    public static void main(String[] args) {
        A a = new A(new B());
    }
}

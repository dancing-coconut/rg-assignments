class A {
    public B b;

    public A() {}
}

class B {}

public class FieldInjection {
    public static void main(String[] args) {
        A a = new A();
        a.b = new B();
    }
}


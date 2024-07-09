class A {
    private B b;

    public A() {}

    public void setB(B b) {
        this.b = b;
    }
}

class B {}

public class MethodInjection {
    public static void main(String[] args) {
        A a = new A();
        a.setB(new B());
    }
}


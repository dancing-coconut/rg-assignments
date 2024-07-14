interface CheckPrint {
    public void check(String name);
    default void display(String name) {
        System.out.println("The entered name is " + name);
    }
}

class UppercaseChecker implements CheckPrint {
    @Override
    public void check(String name) {
        if(name.equals(name.toUpperCase())) {
            System.out.println("Uppercase condition check succeeded.");
        } else {
            System.out.println("Uppercase condition check failed.");
        }
    }
}

class LowercaseChecker implements CheckPrint {
    @Override
    public void check(String name) {
        if(name.equals(name.toLowerCase())) {
            System.out.println("Lowercase condition check succeeded.");
        } else {
            System.out.println("Lowercase condition check failed.");
        }
    }
}

public class DefaultStaticMethods {
    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";

        UppercaseChecker uppercaseChecker = new UppercaseChecker();
        LowercaseChecker lowercaseChecker = new LowercaseChecker();

        uppercaseChecker.check(s1);
        uppercaseChecker.display(s1);
        lowercaseChecker.check(s2);
        lowercaseChecker.display(s2);
    }
}

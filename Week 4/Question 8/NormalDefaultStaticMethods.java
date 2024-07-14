interface CheckPrintNormal {
    public void check(String name);
    public void display(String name);
}

class UppercaseCheckerNormal implements CheckPrintNormal {
    @Override
    public void check(String name) {
        if(name.equals(name.toUpperCase())) {
            System.out.println("Uppercase condition check succeeded.");
        } else {
            System.out.println("Uppercase condition check failed.");
        }
    }

    @Override
    public void display(String name) {
        System.out.println("The entered name is " + name);
    }
}

class LowercaseCheckerNormal implements CheckPrintNormal {
    @Override
    public void check(String name) {
        if(name.equals(name.toLowerCase())) {
            System.out.println("Lowercase condition check succeeded.");
        } else {
            System.out.println("Lowercase condition check failed.");
        }
    }

    @Override
    public void display(String name) {
        System.out.println("The entered name is " + name);
    }
}

public class NormalDefaultStaticMethods {
    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";

        UppercaseCheckerNormal uppercaseChecker = new UppercaseCheckerNormal();
        LowercaseCheckerNormal lowercaseChecker = new LowercaseCheckerNormal();

        uppercaseChecker.check(s1);
        uppercaseChecker.display(s1);
        lowercaseChecker.check(s2);
        lowercaseChecker.display(s2);
    }
}

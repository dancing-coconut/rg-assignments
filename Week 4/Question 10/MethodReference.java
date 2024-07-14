@FunctionalInterface
interface Convertor {
    public String uppercase(String name);
}
public class MethodReference {
    public static void main(String[] args) {
        String name = "PayPal";
        // Lambda Expression
        Convertor convertorLambda = (String str) -> str.toUpperCase();
        System.out.println(convertorLambda.uppercase(name));

        // Method Reference
        Convertor convertorMethod = String::toUpperCase;
        System.out.println(convertorMethod.uppercase(name));
    }
}

@FunctionalInterface
interface CalculatorSample {
    public int calculate(int a, int b);
}
public class LambdaFunctionalExample {
    public static void main(String[] args) {
        CalculatorSample calculatorSample = (int a, int b) -> a * a + b * b + 2 * a * b;
        System.out.println(calculatorSample.calculate(10, 20));
    }
}

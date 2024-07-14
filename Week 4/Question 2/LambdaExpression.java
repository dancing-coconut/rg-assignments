@FunctionalInterface
interface Calculator {
    public void display(int value);

    default int add(int a, int b) {
        return a + b;
    }

    default int sub(int a, int b) {
        return a - b;
    }

    default int mul(int a, int b) {
        return a * b;
    }

    default int div(int a, int b) {
        return a / b;
    }
}

public class LambdaExpression {
    public static void main(String[] args) {
        Calculator calculatorAdd = (int value) -> {
            System.out.println("The operation is addition: a + b");
            System.out.println("The result is " + value);
        };

        int resultAdd = calculatorAdd.add(1, 2);
        calculatorAdd.display(resultAdd);

        Calculator calculatorSub = (int value) -> {
            System.out.println("The operation is subtraction: a - b");
            System.out.println("The result is " + value);
        };

        int resultSub = calculatorSub.sub(2, 1);
        calculatorSub.display(resultSub);
    }
}
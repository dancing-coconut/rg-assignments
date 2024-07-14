interface CalculatorNormal {
    public void display(int value);

    public int add(int a, int b);

    public int sub(int a, int b);

    public int mul(int a, int b);

    public int div(int a, int b);
}

class DualNormalLambdaExpression implements  CalculatorNormal{

    @Override
    public void display(int value) {
        System.out.println("The operation is subtraction: a - b");
        System.out.println("The result is " + value);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
public class NormalLambdaExpression implements CalculatorNormal{
    @Override
    public void display(int value) {
        System.out.println("The operation is addition: a + b");
        System.out.println("The result is " + value);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        NormalLambdaExpression normalLambdaExpression = new NormalLambdaExpression();
        int resultAdd = normalLambdaExpression.add(1, 2);
        normalLambdaExpression.display(resultAdd);

        DualNormalLambdaExpression dualNormalLambdaExpression = new DualNormalLambdaExpression();
        int resultSub = dualNormalLambdaExpression.sub(2, 1);
        dualNormalLambdaExpression.display(resultSub);
    }
}

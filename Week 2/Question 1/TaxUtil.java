class TaxUtil1 {
    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }
}

class TaxUtil2 {
    public double calculateTax(double amount) {
        return amount * 0.15;
    }
}

class TaxUtil3 {
    final double rate = 0.15;

    public double calculateTax(double amount) {
        return amount * rate;
    }
}

public class TaxUtil {
    public static void main(String[] args) {
        TaxUtil1 taxUtil1 = new TaxUtil1();
        TaxUtil2 taxUtil2 = new TaxUtil2();
        TaxUtil3 taxUtil3 = new TaxUtil3();
        double res1 = taxUtil1.calculateTax(10.0, 0.15);
        double res2 = taxUtil2.calculateTax(10.0);
        double res3 = taxUtil3.calculateTax(10.0);
    }
}

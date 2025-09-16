class BasicMath {
    int calculate(int a, int b) {
        return a + b;
    }

    double calculate(double a, double b) {
        return a + b;
    }
}

class AdvancedMath extends BasicMath {
    int calculate(int a, int b, int c) {
        return a * b * c; // new overload
    }

    double calculate(double a, double b, double c) {
        return a * b * c;
    }
}

public class HW5 {
    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();

        System.out.println("Sum (int): " + am.calculate(3, 4));
        System.out.println("Sum (double): " + am.calculate(2.5, 3.5));
        System.out.println("Product (int): " + am.calculate(2, 3, 4));
        System.out.println("Product (double): " + am.calculate(1.5, 2.0, 3.0));
    }
}

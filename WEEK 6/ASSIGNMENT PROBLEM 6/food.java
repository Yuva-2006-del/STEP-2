abstract class Food {
    // Template method
    final void prepare() {
        wash();
        cook();
        serve();
    }

    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    void wash() { System.out.println("Washing veggies for pizza..."); }
    void cook() { System.out.println("Baking pizza in oven..."); }
    void serve() { System.out.println("Serving pizza with cheese..."); }
}

class Soup extends Food {
    void wash() { System.out.println("Washing ingredients for soup..."); }
    void cook() { System.out.println("Boiling soup on stove..."); }
    void serve() { System.out.println("Serving soup in a bowl..."); }
}

public class HW4 {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();

        f1.prepare();
        f2.prepare();
    }
}

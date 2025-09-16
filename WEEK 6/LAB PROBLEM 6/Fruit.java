// Parent class
class Fruit {
    protected String color;
    protected String taste;

    // Constructor
    Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    void showFruitInfo() {
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }
}

// Child class
class Apple extends Fruit {
    private String variety;

    // Constructor
    Apple(String color, String taste, String variety) {
        super(color, taste); // Call parent constructor
        this.variety = variety;
    }

    void showAppleInfo() {
        showFruitInfo(); // inherited method
        System.out.println("Variety: " + variety);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Apple a1 = new Apple("Red", "Sweet", "Fuji");
        a1.showAppleInfo();
    }
}

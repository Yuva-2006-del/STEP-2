class Light {
    String type;

    Light() {
        this("Generic Light"); // calls another constructor
        System.out.println("Default Light constructor");
    }

    Light(String type) {
        this.type = type;
        System.out.println("Light constructor with type: " + type);
    }
}

class LED extends Light {
    int power;

    LED() {
        this("LED", 5); // calls LED(String,int)
        System.out.println("Default LED constructor");
    }

    LED(String type, int power) {
        super(type); // call parent constructor
        this.power = power;
        System.out.println("LED constructor with power: " + power + "W");
    }
}

public class HW1 {
    public static void main(String[] args) {
        new LED();
    }
}

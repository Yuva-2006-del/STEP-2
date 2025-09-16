class Color {
    protected String name;

    Color(String name) {
        this.name = name;
        System.out.println("Color Constructor");
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor Constructor");
    }
}

class RedColor extends PrimaryColor {
    private String shade;

    RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor Constructor");
    }

    void showDetails() {
        System.out.println("Name: " + name + ", Intensity: " + intensity + ", Shade: " + shade);
    }
}

public class Main4 {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 80, "Crimson");
        red.showDetails();
    }
}

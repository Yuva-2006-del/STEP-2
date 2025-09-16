class Weather {
    String condition;

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather: " + condition);
    }

    void report() {
        System.out.println("General weather: " + condition);
    }
}

class Storm extends Weather {
    Storm(String condition) {
        super(condition);
        System.out.println("Storm created");
    }

    @Override
    void report() {
        System.out.println("Stormy weather: " + condition);
    }
}

class Thunderstorm extends Storm {
    Thunderstorm(String condition) {
        super(condition);
        System.out.println("Thunderstorm created");
    }

    @Override
    void report() {
        System.out.println("Severe thunderstorm: " + condition);
    }
}

class Sunshine extends Weather {
    Sunshine(String condition) {
        super(condition);
        System.out.println("Sunshine created");
    }

    @Override
    void report() {
        System.out.println("Bright sunshine: " + condition);
    }
}

public class HW6 {
    public static void main(String[] args) {
        Weather[] weathers = {
            new Thunderstorm("Heavy rain + lightning"),
            new Sunshine("Clear skies")
        };

        for (Weather w : weathers) {
            w.report(); // polymorphic calls
        }
    }
}

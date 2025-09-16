class Instrument {
    protected String name, material;

    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    void play() {
        System.out.println(name + " is playing...");
    }
}

class Piano extends Instrument {
    private int keys;

    Piano(String material, int keys) {
        super("Piano", material);
        this.keys = keys;
    }

    @Override
    void play() {
        System.out.println("Piano with " + keys + " keys is playing.");
    }
}

class Guitar extends Instrument {
    private int strings;

    Guitar(String material, int strings) {
        super("Guitar", material);
        this.strings = strings;
    }

    @Override
    void play() {
        System.out.println("Guitar with " + strings + " strings is playing.");
    }
}

class Drum extends Instrument {
    private String type;

    Drum(String material, String type) {
        super("Drum", material);
        this.type = type;
    }

    @Override
    void play() {
        System.out.println(type + " Drum made of " + material + " is playing.");
    }
}

public class Main5 {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Wood", 88),
            new Guitar("Steel", 6),
            new Drum("Plastic", "Bass")
        };

        for (Instrument inst : instruments) {
            inst.play();
        }
    }
}

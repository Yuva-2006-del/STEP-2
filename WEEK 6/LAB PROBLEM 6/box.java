class Box {
    void pack() {
        System.out.println("Packing items in a box.");
    }

    void unpack() {
        System.out.println("Unpacking items from the box.");
    }
}

class GiftBox extends Box {
    @Override
    void pack() {
        super.pack(); // keep parent functionality
        System.out.println("Adding gift wrap and ribbon.");
    }

    @Override
    void unpack() {
        super.unpack(); // keep parent functionality
        System.out.println("Removing gift wrap and ribbon.");
    }
}

public class Main6 {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}

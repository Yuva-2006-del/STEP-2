class Artwork {
    String title;
    public Artwork(String title) { this.title = title; }
}

class Painting extends Artwork {
    public Painting(String t) { super(t); }
    public void showPalette() { System.out.println("Painting " + title + " with oil colors & frames."); }
}

class Sculpture extends Artwork {
    public Sculpture(String t) { super(t); }
    public void showMaterial() { System.out.println("Sculpture " + title + " made of marble."); }
}

class DigitalArt extends Artwork {
    public DigitalArt(String t) { super(t); }
    public void showResolution() { System.out.println("Digital Art " + title + " at 4K resolution."); }
}

class Photography extends Artwork {
    public Photography(String t) { super(t); }
    public void showCameraSettings() { System.out.println("Photo " + title + " with DSLR settings."); }
}

public class ArtGallery {
    public static void main(String[] args) {
        Artwork a = new Sculpture("David");
        if (a instanceof Sculpture) {
            Sculpture s = (Sculpture) a; // downcasting
            s.showMaterial();
        }
    }
}

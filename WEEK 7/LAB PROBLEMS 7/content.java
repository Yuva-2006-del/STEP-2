class Content {
    String title;
    public Content(String title) { this.title = title; }
}

class Movie extends Content {
    public Movie(String title) { super(title); }
    public void showSubtitles() { System.out.println("Showing subtitles for movie " + title); }
}

class TVSeries extends Content {
    public TVSeries(String title) { super(title); }
    public void nextEpisode() { System.out.println("Next episode suggestion for series " + title); }
}

class Documentary extends Content {
    public Documentary(String title) { super(title); }
    public void showRelatedContent() { System.out.println("Showing related documentaries for " + title); }
}

public class StreamingPlatform {
    public static void main(String[] args) {
        Content c = new Movie("Inception");

        if (c instanceof Movie) {
            Movie m = (Movie) c; // Downcasting
            m.showSubtitles();
        }
    }
}

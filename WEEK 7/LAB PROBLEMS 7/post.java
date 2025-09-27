class Post {
    String author, content, time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(author + ": " + content + " [" + time + "]");
    }
}

class InstagramPost extends Post {
    public InstagramPost(String author, String content, String time) {
        super(author, content, time);
    }
    @Override
    public void display() {
        System.out.println("📸 Instagram: " + author + " - " + content + " ❤️ #hashtags [" + time + "]");
    }
}

class TwitterPost extends Post {
    public TwitterPost(String author, String content, String time) {
        super(author, content, time);
    }
    @Override
    public void display() {
        System.out.println("🐦 Twitter: " + author + " - " + content + " (" + content.length() + " chars, Retweets: 10) [" + time + "]");
    }
}

class LinkedInPost extends Post {
    public LinkedInPost(String author, String content, String time) {
        super(author, content, time);
    }
    @Override
    public void display() {
        System.out.println("💼 LinkedIn: " + author + " - " + content + " | Professional Connections [" + time + "]");
    }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Alice", "Vacation time!", "10:00 AM");
        Post p2 = new TwitterPost("Bob", "Java OOP Rocks!", "11:30 AM");
        Post p3 = new LinkedInPost("Carol", "Looking for opportunities", "12:15 PM");

        p1.display();
        p2.display();
        p3.display();
    }
}

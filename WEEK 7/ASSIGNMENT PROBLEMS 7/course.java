class Course {
    String title, instructor, date;
    public Course(String title, String instructor, String date) {
        this.title = title; this.instructor = instructor; this.date = date;
    }
    public void displayProgress() {
        System.out.println(title + " by " + instructor + " enrolled on " + date);
    }
}

class VideoCourse extends Course {
    int percent, watchTime;
    public VideoCourse(String t, String i, String d, int p, int w) { super(t,i,d); percent=p; watchTime=w; }
    @Override public void displayProgress() {
        System.out.println("🎥 " + title + ": " + percent + "% completed, Watch time " + watchTime + " hrs");
    }
}

class InteractiveCourse extends Course {
    int quizzes, projects;
    public InteractiveCourse(String t, String i, String d, int q, int p) { super(t,i,d); quizzes=q; projects=p; }
    @Override public void displayProgress() {
        System.out.println("🧑‍💻 " + title + ": Quizzes " + quizzes + ", Projects " + projects);
    }
}

class ReadingCourse extends Course {
    int pages, notes;
    public ReadingCourse(String t, String i, String d, int p, int n) { super(t,i,d); pages=p; notes=n; }
    @Override public void displayProgress() {
        System.out.println("📚 " + title + ": Pages read " + pages + ", Notes taken " + notes);
    }
}

class CertificationCourse extends Course {
    int attempts; boolean certified;
    public CertificationCourse(String t, String i, String d, int a, boolean c) { super(t,i,d); attempts=a; certified=c; }
    @Override public void displayProgress() {
        System.out.println("🎓 " + title + ": Exam attempts " + attempts + ", Certified = " + certified);
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course c1 = new VideoCourse("Java Basics", "Alice", "01-09-25", 80, 10);
        Course c2 = new InteractiveCourse("DSA", "Bob", "05-09-25", 5, 2);
        Course c3 = new CertificationCourse("AWS", "Carol", "10-09-25", 2, true);
        c1.displayProgress();
        c2.displayProgress();
        c3.displayProgress();
    }
}

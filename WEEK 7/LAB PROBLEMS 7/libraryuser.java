class LibraryUser {
    String name;
    public LibraryUser(String name) {
        this.name = name;
    }
    public void entryLog() {
        System.out.println(name + " entered the library.");
    }
}

class Student extends LibraryUser {
    public Student(String name) { super(name); }
    public void borrowBook() { System.out.println(name + " borrowed a book."); }
    public void accessComputer() { System.out.println(name + " is using a computer."); }
}

class Faculty extends LibraryUser {
    public Faculty(String name) { super(name); }
    public void reserveBook() { System.out.println(name + " reserved a book."); }
    public void accessResearchDB() { System.out.println(name + " is using research database."); }
}

class Guest extends LibraryUser {
    public Guest(String name) { super(name); }
    public void browseBooks() { System.out.println(name + " is browsing books."); }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryUser u1 = new Student("Alice"); // Upcasting
        LibraryUser u2 = new Faculty("Bob");
        LibraryUser u3 = new Guest("Charlie");

        u1.entryLog();
        u2.entryLog();
        u3.entryLog();
    }
}

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public final class ImmutableStudent {
    private final String studentId;
    private final String name;
    private final LocalDate birthDate;
    private final List<String> courses;
    private final Map<String, Double> grades;
    private final LocalDate graduationDate;

    public ImmutableStudent(String studentId, String name, LocalDate birthDate,
                            List<String> courses, Map<String, Double> grades, LocalDate graduationDate) {
        if (studentId == null || name == null || birthDate == null)
            throw new IllegalArgumentException("ID, name, and birth date are required.");
        
        this.studentId = studentId;
        this.name = name;
        this.birthDate = birthDate;
        this.courses = new ArrayList<>(courses != null ? courses : List.of());
        this.grades = new HashMap<>(grades != null ? grades : Map.of());
        this.graduationDate = graduationDate;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public List<String> getCourses() { return new ArrayList<>(courses); }
    public Map<String, Double> getGrades() { return new HashMap<>(grades); }
    public LocalDate getGraduationDate() { return graduationDate; }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public double getGPA() {
        return grades.values().stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    public boolean isGraduated() {
        return graduationDate != null;
    }

    public ImmutableStudent withGraduationDate(LocalDate date) {
        return new ImmutableStudent(studentId, name, birthDate, courses, grades, date);
    }

    public ImmutableStudent withAdditionalCourse(String course) {
        List<String> newCourses = new ArrayList<>(courses);
        newCourses.add(course);
        return new ImmutableStudent(studentId, name, birthDate, newCourses, grades, graduationDate);
    }

    public ImmutableStudent withGrade(String course, double grade) {
        Map<String, Double> newGrades = new HashMap<>(grades);
        newGrades.put(course, grade);
        return new ImmutableStudent(studentId, name, birthDate, courses, newGrades, graduationDate);
    }

    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(studentId, newName, birthDate, courses, grades, graduationDate);
    }

    @Override
    public String toString() {
        return name + " (" + studentId + "), GPA: " + getGPA() + ", Graduated: " + isGraduated();
    }

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(List.of("Math", "Science"));
        Map<String, Double> grades = new HashMap<>();
        grades.put("Math", 90.0);
        grades.put("Science", 85.0);

        ImmutableStudent student = new ImmutableStudent("S001", "Alice", LocalDate.of(2000, 1, 1), courses, grades, null);
        System.out.println(student);

        // Try modifying returned values (should not affect internal state)
        student.getCourses().add("Hacked");
        student.getGrades().put("Hacked", 0.0);
        System.out.println("After attempted external mutation: " + student);

        // Create modified copy
        ImmutableStudent updated = student.withAdditionalCourse("English").withGrade("English", 88.0);
        System.out.println("Updated student: " + updated);
        System.out.println("Original student still: " + student);
    }
}

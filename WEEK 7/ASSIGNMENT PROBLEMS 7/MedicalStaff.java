class MedicalStaff {
    String name;
    public MedicalStaff(String name) { this.name = name; }
    public void shiftSchedule() { System.out.println(name + " scheduled for shift."); }
}

class Doctor extends MedicalStaff {
    public Doctor(String n) { super(n); }
    public void diagnose() { System.out.println(name + " diagnosing patients."); }
}

class Nurse extends MedicalStaff {
    public Nurse(String n) { super(n); }
    public void assist() { System.out.println(name + " assisting doctor."); }
}

class Technician extends MedicalStaff {
    public Technician(String n) { super(n); }
    public void runTests() { System.out.println(name + " running lab tests."); }
}

class Administrator extends MedicalStaff {
    public Administrator(String n) { super(n); }
    public void manageRecords() { System.out.println(name + " managing hospital records."); }
}

public class HospitalSystem {
    public static void main(String[] args) {
        MedicalStaff s1 = new Doctor("Dr. Rao");
        MedicalStaff s2 = new Nurse("Sister Anu");
        MedicalStaff s3 = new Technician("Raj");
        s1.shiftSchedule();
        s2.shiftSchedule();
        s3.shiftSchedule();
    }
}

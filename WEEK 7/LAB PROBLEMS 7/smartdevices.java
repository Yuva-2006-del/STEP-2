abstract class SmartDevice {
    String id;
    public SmartDevice(String id) { this.id = id; }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String id) { super(id); }
    public void controlLights() { System.out.println("Classroom " + id + " lights controlled."); }
}

class SmartLab extends SmartDevice {
    public SmartLab(String id) { super(id); }
    public void manageEquipment() { System.out.println("Lab " + id + " equipment managed."); }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String id) { super(id); }
    public void trackOccupancy() { System.out.println("Library " + id + " occupancy tracked."); }
}

public class CampusIoT {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("C1"),
            new SmartLab("L1"),
            new SmartLibrary("Lib1")
        };

        for (SmartDevice d : devices) {
            if (d instanceof SmartClassroom) {
                ((SmartClassroom) d).controlLights();
            } else if (d instanceof SmartLab) {
                ((SmartLab) d).manageEquipment();
            } else if (d instanceof SmartLibrary) {
                ((SmartLibrary) d).trackOccupancy();
            }
        }
    }
}

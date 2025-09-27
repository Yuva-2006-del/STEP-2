abstract class SmartDevice { String id; public SmartDevice(String id){this.id=id;} }

class SmartTV extends SmartDevice {
    public SmartTV(String id){super(id);}
    public void controlTV(){System.out.println("TV " + id + " channel changed.");}
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String id){super(id);}
    public void setTemp(){System.out.println("Thermostat " + id + " set to 24°C.");}
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String id){super(id);}
    public void enableAlarm(){System.out.println("Security " + id + " alarm armed.");}
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String id){super(id);}
    public void startCooking(){System.out.println("Kitchen device " + id + " started cooking.");}
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("TV1"),
            new SmartThermostat("TH1"),
            new SmartSecurity("SEC1"),
            new SmartKitchen("KIT1")
        };

        for (SmartDevice d : devices) {
            if (d instanceof SmartTV) ((SmartTV) d).controlTV();
            else if (d instanceof SmartThermostat) ((SmartThermostat) d).setTemp();
            else if (d instanceof SmartSecurity) ((SmartSecurity) d).enableAlarm();
            else if (d instanceof SmartKitchen) ((SmartKitchen) d).startCooking();
        }
    }
}

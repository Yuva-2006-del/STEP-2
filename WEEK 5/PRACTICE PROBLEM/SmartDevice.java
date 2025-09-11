import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;
    private final LocalDateTime startupTime;

    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    private String deviceName;
    private boolean isEnabled;

    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now().minusYears(1); // Simulate old device
        this.serialNumber = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public long getUptime() {
        return Duration.between(startupTime, LocalDateTime.now()).getSeconds();
    }

    public int getDeviceAge() {
        return Period.between(manufacturingDate.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
    }

    public void setEncryptionKey(String key) {
        if (key.length() < 8) {
            throw new IllegalArgumentException("Encryption key too weak.");
        }
        this.hashedEncryptionKey = key.hashCode();
    }

    public void setAdminPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password too weak.");
        }
        this.hashedAdminPassword = password.hashCode();
    }

    public boolean validateEncryptionKey(String key) {
        return key.hashCode() == hashedEncryptionKey;
    }

    public boolean validateAdminPassword(String password) {
        return password.hashCode() == hashedAdminPassword;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        this.deviceName = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public Map<String, String> getPropertyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("deviceId", "read-only");
        info.put("manufacturingDate", "read-only");
        info.put("serialNumber", "read-only");
        info.put("uptime", "computed read-only");
        info.put("deviceAge", "computed read-only");
        info.put("encryptionKey", "write-only");
        info.put("adminPassword", "write-only");
        info.put("deviceName", "read-write");
        info.put("isEnabled", "read-write");
        return info;
    }

    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
    }

    public static void main(String[] args) {
        SmartDevice device1 = new SmartDevice("Thermostat");
        SmartDevice device2 = new SmartDevice("Camera");

        // Read-only
        System.out.println("Device ID: " + device1.getDeviceId());
        System.out.println("Manufactured: " + device1.getManufacturingDate());
        System.out.println("Serial: " + device1.getSerialNumber());
        System.out.println("Uptime: " + device1.getUptime() + " seconds");
        System.out.println("Device Age: " + device1.getDeviceAge() + " years");

        // Write-only
        device1.setEncryptionKey("secure123");
        device1.setAdminPassword("admin456");
        System.out.println("Key Valid: " + device1.validateEncryptionKey("secure123"));
        System.out.println("Password Valid: " + device1.validateAdminPassword("admin456"));

        // Read-write
        System.out.println("Name: " + device1.getDeviceName());
        device1.setDeviceName("Smart Thermostat");
        System.out.println("New Name: " + device1.getDeviceName());
        System.out.println("Enabled: " + device1.isEnabled());
        device1.setEnabled(false);
        System.out.println("Enabled Now: " + device1.isEnabled());

        // Device independence
        System.out.println("Device 2 Name: " + device2.getDeviceName());
        System.out.println("Device 2 Uptime: " + device2.getUptime());

        // Utility methods
        System.out.println("Properties:");
        device1.getPropertyInfo().forEach((k, v) -> System.out.println(k + ": " + v));

        // Reset write-only properties
        device1.resetDevice();
        System.out.println("After reset:");
        System.out.println("Key Valid: " + device1.validateEncryptionKey("secure123"));
    }
}

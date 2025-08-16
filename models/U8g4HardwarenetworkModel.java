package model;

/** Model for: Manage Hardware and Network Infrastructure */
public class U8g4HardwarenetworkModel {
    private String deviceName;
private String ipAddress;
private String macAddress;

    public U8g4HardwarenetworkModel(String deviceName, String ipAddress, String macAddress) {
        this.deviceName = deviceName;
    this.ipAddress = ipAddress;
    this.macAddress = macAddress;
    }

    public String getDeviceName() { return deviceName; }

public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

public String getIpAddress() { return ipAddress; }

public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

public String getMacAddress() { return macAddress; }

public void setMacAddress(String macAddress) { this.macAddress = macAddress; }
}
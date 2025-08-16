package model;

/** Model for: Monitor System Performance and Uptime */
public class U8g3PerformanceuptimeModel {
    private double cpu;
private double memory;
private double disk;

    public U8g3PerformanceuptimeModel(double cpu, double memory, double disk) {
        this.cpu = cpu;
    this.memory = memory;
    this.disk = disk;
    }

    public double getCpu() { return cpu; }

public void setCpu(double cpu) { this.cpu = cpu; }

public double getMemory() { return memory; }

public void setMemory(double memory) { this.memory = memory; }

public double getDisk() { return disk; }

public void setDisk(double disk) { this.disk = disk; }
}
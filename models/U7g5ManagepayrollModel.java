package model;

/** Model for: Manage Payroll and Staff Compensation */
public class U7g5ManagepayrollModel {
    private String employeeId;
private double hoursOrSalary;

    public U7g5ManagepayrollModel(String employeeId, double hoursOrSalary) {
        this.employeeId = employeeId;
    this.hoursOrSalary = hoursOrSalary;
    }

    public String getEmployeeId() { return employeeId; }

public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

public double getHoursOrSalary() { return hoursOrSalary; }

public void setHoursOrSalary(double hoursOrSalary) { this.hoursOrSalary = hoursOrSalary; }
}
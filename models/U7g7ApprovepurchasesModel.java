package model;

/** Model for: Approve and Monitor Equipment and Facility Purchases */
public class U7g7ApprovepurchasesModel {
    private String itemDescription;
private double cost;
private String vendor;

    public U7g7ApprovepurchasesModel(String itemDescription, double cost, String vendor) {
        this.itemDescription = itemDescription;
    this.cost = cost;
    this.vendor = vendor;
    }

    public String getItemDescription() { return itemDescription; }

public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

public double getCost() { return cost; }

public void setCost(double cost) { this.cost = cost; }

public String getVendor() { return vendor; }

public void setVendor(String vendor) { this.vendor = vendor; }
}
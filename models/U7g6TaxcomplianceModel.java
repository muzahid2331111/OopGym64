package model;

/** Model for: Ensure Tax Compliance and Reporting */
public class U7g6TaxcomplianceModel {
    private String taxId;
private String filingStatus;

    public U7g6TaxcomplianceModel(String taxId, String filingStatus) {
        this.taxId = taxId;
    this.filingStatus = filingStatus;
    }

    public String getTaxId() { return taxId; }

public void setTaxId(String taxId) { this.taxId = taxId; }

public String getFilingStatus() { return filingStatus; }

public void setFilingStatus(String filingStatus) { this.filingStatus = filingStatus; }
}
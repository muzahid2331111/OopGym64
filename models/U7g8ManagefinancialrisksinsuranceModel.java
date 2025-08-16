package model;

/** Model for: Manage Financial Risks and Insurance */
public class U7g8ManagefinancialrisksinsuranceModel {
    private String policyId;
private String provider;
private double premium;

    public U7g8ManagefinancialrisksinsuranceModel(String policyId, String provider, double premium) {
        this.policyId = policyId;
    this.provider = provider;
    this.premium = premium;
    }

    public String getPolicyId() { return policyId; }

public void setPolicyId(String policyId) { this.policyId = policyId; }

public String getProvider() { return provider; }

public void setProvider(String provider) { this.provider = provider; }

public double getPremium() { return premium; }

public void setPremium(double premium) { this.premium = premium; }
}
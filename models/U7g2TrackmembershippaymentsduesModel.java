package model;

/** Model for: Track Membership Payments and Dues */
public class U7g2TrackmembershippaymentsduesModel {
    private String memberId;
private double paymentAmount;

    public U7g2TrackmembershippaymentsduesModel(String memberId, double paymentAmount) {
        this.memberId = memberId;
    this.paymentAmount = paymentAmount;
    }

    public String getMemberId() { return memberId; }

public void setMemberId(String memberId) { this.memberId = memberId; }

public double getPaymentAmount() { return paymentAmount; }

public void setPaymentAmount(double paymentAmount) { this.paymentAmount = paymentAmount; }
}
package com.example.oopgym64.Dietetian;

public class Supplement {
    private String memberID, timing;
    String supplement;
    int dosage;

    public Supplement(String memberID, int dosage, String timing, String supplement) {
        this.memberID = memberID;
        this.dosage = dosage;
        this.timing = timing;
        this.supplement = supplement;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
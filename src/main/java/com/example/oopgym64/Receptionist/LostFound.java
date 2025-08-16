package com.example.oopgym64.Receptionist;

public class LostFound {
    String memberID, referenceID , details;

    public LostFound(String memberID, String referenceID, String details) {
        this.memberID = memberID;
        this.referenceID = referenceID;
        this.details = details;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

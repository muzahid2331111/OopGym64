package com.example.oopgym64.Dietetian;

public class ClientProfile {
    private String memberID , email, medicalNote;
    private int  phone;

    public ClientProfile(String memberID, String email, String medicalNote, int phone) {
        this.memberID = memberID;
        this.email = email;
        this.medicalNote = medicalNote;
        this.phone = phone;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMedicalNote() {
        return medicalNote;
    }

    public void setMedicalNote(String medicalNote) {
        this.medicalNote = medicalNote;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

package com.example.oopgym64.Receptionist;

public class NewMember {
    String receptionistID, memberName;
    int age, contact;

    public NewMember(String receptionistID, String memberName, int age, int contact) {
        this.receptionistID = receptionistID;
        this.memberName = memberName;
        this.age = age;
        this.contact = contact;
    }

    public String getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}

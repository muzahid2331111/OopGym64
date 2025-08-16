package com.example.oopgym64.Dietetian;

public class Training {
    String memberID, diettiming, discussion, schedule;

    public Training(String memberID, String diettiming, String discussion, String schedule) {
        this.memberID = memberID;
        this.diettiming = diettiming;
        this.discussion = discussion;
        this.schedule = schedule;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getDiettiming() {
        return diettiming;
    }

    public void setDiettiming(String diettiming) {
        this.diettiming = diettiming;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

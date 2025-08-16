package com.example.oopgym64.Dietetian;

public class DietaryHabits {
    private String memberID;
    private String dietPlan;

    public DietaryHabits(String memberID, String dietPlan) {
        this.memberID = memberID;
        this.dietPlan = dietPlan;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(String dietPlan) {
        this.dietPlan = dietPlan;
    }
}


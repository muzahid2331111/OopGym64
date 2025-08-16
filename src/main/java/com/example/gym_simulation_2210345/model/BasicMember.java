package com.example.gym_simulation_2210345.model;

import java.util.Arrays;
import java.util.List;

public class BasicMember extends User {
    private static final double MONTHLY_FEE = 29.99;
    private static final String MEMBERSHIP_TYPE = "Basic";

    public BasicMember(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public String getMembershipType() {
        return MEMBERSHIP_TYPE;
    }

    @Override
    public double getMonthlyFee() {
        return MONTHLY_FEE;
    }

    @Override
    public List<String> getAvailableFeatures() {
        return Arrays.asList(
            "Access to gym equipment",
            "Group fitness classes (basic)",
            "Locker room access",
            "Basic workout tracking",
            "Progress monitoring",
            "Class schedule viewing",
            "Profile management",
            "Feedback submission"
        );
    }


    public boolean canJoinClass(GroupClass groupClass) {

        return !groupClass.isPremiumOnly() && !groupClass.isFull();
    }

    public boolean canBookSession() {

        return isActive;
    }
}

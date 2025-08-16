package com.example.gym_simulation_2210345.model;

import java.util.Arrays;
import java.util.List;

public class PremiumMember extends User {
    private static final double MONTHLY_FEE = 79.99;
    private static final String MEMBERSHIP_TYPE = "Premium";
    
    private String personalTrainerId;
    private String dietPlanId;
    private List<String> wellnessAppointments;
    private List<String> supplementLogs;
    private List<String> fitnessGoals;

    public PremiumMember(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.wellnessAppointments = new java.util.ArrayList<>();
        this.supplementLogs = new java.util.ArrayList<>();
        this.fitnessGoals = new java.util.ArrayList<>();
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
            "All Basic features",
            "1-on-1 Personal Training",
            "Personalized Diet Plans",
            "Premium-only Fitness Classes",
            "Wellness Lounge Access",
            "Advanced Progress Analytics",
            "Monthly Fitness Assessments",
            "Supplement Tracking",
            "Goal Setting with AI/Trainer",
            "Priority Booking",
            "Extended Gym Hours"
        );
    }


    public boolean canJoinPremiumClass(GroupClass groupClass) {

        return !groupClass.isFull();
    }

    public boolean canBookPersonalTraining() {
        return isActive && personalTrainerId != null;
    }

    public boolean canAccessWellnessLounge() {
        return isActive;
    }

    public void setPersonalTrainer(String trainerId) {
        this.personalTrainerId = trainerId;
    }

    public String getPersonalTrainerId() {
        return personalTrainerId;
    }

    public void setDietPlan(String dietPlanId) {
        this.dietPlanId = dietPlanId;
    }

    public String getDietPlanId() {
        return dietPlanId;
    }

    public void addWellnessAppointment(String appointmentId) {
        this.wellnessAppointments.add(appointmentId);
    }

    public void addSupplementLog(String supplementLogId) {
        this.supplementLogs.add(supplementLogId);
    }

    public void addFitnessGoal(String goal) {
        this.fitnessGoals.add(goal);
    }

    public List<String> getWellnessAppointments() {
        return wellnessAppointments;
    }

    public List<String> getSupplementLogs() {
        return supplementLogs;
    }

    public List<String> getFitnessGoals() {
        return fitnessGoals;
    }
}

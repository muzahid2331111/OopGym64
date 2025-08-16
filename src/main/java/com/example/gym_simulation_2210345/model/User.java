package com.example.gym_simulation_2210345.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String password;
    protected String phoneNumber;
    protected LocalDate dateOfBirth;
    protected String address;
    protected LocalDate registrationDate;
    protected boolean isActive;
    protected List<WorkoutSession> workoutSessions;
    protected List<GroupClass> enrolledClasses;
    protected WorkoutPlan workoutPlan;
    protected double weight;
    protected double height;
    protected List<String> fitnessGoals;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = LocalDate.now();
        this.isActive = true;
        this.workoutSessions = new ArrayList<>();
        this.enrolledClasses = new ArrayList<>();
        this.fitnessGoals = new ArrayList<>();
    }


    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public List<WorkoutSession> getWorkoutSessions() { return workoutSessions; }
    public void setWorkoutSessions(List<WorkoutSession> workoutSessions) { this.workoutSessions = workoutSessions; }

    public List<GroupClass> getEnrolledClasses() { return enrolledClasses; }
    public void setEnrolledClasses(List<GroupClass> enrolledClasses) { this.enrolledClasses = enrolledClasses; }

    public WorkoutPlan getWorkoutPlan() { return workoutPlan; }
    public void setWorkoutPlan(WorkoutPlan workoutPlan) { this.workoutPlan = workoutPlan; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public List<String> getFitnessGoals() { return fitnessGoals; }
    public void setFitnessGoals(List<String> fitnessGoals) { this.fitnessGoals = fitnessGoals; }


    public abstract String getMembershipType();
    public abstract double getMonthlyFee();
    public abstract List<String> getAvailableFeatures();
}

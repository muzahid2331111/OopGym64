package com.example.gym_simulation_2210345.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class WorkoutPlan {
    private String planId;
    private String memberId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String goal;
    private List<WorkoutDay> workoutDays;
    private String notes;
    private boolean isActive;

    public WorkoutPlan(String planId, String memberId, String goal) {
        this.planId = planId;
        this.memberId = memberId;
        this.goal = goal;
        this.startDate = LocalDate.now();
        this.workoutDays = new ArrayList<>();
        this.isActive = true;
    }


    public String getPlanId() { return planId; }
    public void setPlanId(String planId) { this.planId = planId; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public List<WorkoutDay> getWorkoutDays() { return workoutDays; }
    public void setWorkoutDays(List<WorkoutDay> workoutDays) { this.workoutDays = workoutDays; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public void addWorkoutDay(WorkoutDay workoutDay) {
        this.workoutDays.add(workoutDay);
    }

    public void deactivate() {
        this.isActive = false;
        this.endDate = LocalDate.now();
    }
}

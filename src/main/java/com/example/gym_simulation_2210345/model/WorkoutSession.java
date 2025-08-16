package com.example.gym_simulation_2210345.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class WorkoutSession {
    private String sessionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String sessionType;
    private List<Exercise> exercises;
    private double caloriesBurned;
    private String notes;
    private boolean isCompleted;

    public WorkoutSession(String sessionId, LocalDateTime startTime, String sessionType) {
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.sessionType = sessionType;
        this.exercises = new ArrayList<>();
        this.isCompleted = false;
    }


    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getSessionType() { return sessionType; }
    public void setSessionType(String sessionType) { this.sessionType = sessionType; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }

    public double getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(double caloriesBurned) { this.caloriesBurned = caloriesBurned; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public void completeSession() {
        this.endTime = LocalDateTime.now();
        this.isCompleted = true;
    }
}

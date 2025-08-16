package com.example.gym_simulation_2210345.model;

import java.util.List;
import java.util.ArrayList;

public class WorkoutDay {
    private String dayId;
    private String dayName;
    private String focus;
    private List<Exercise> exercises;
    private int estimatedDuration;
    private String notes;

    public WorkoutDay(String dayId, String dayName, String focus) {
        this.dayId = dayId;
        this.dayName = dayName;
        this.focus = focus;
        this.exercises = new ArrayList<>();
    }


    public String getDayId() { return dayId; }
    public void setDayId(String dayId) { this.dayId = dayId; }

    public String getDayName() { return dayName; }
    public void setDayName(String dayName) { this.dayName = dayName; }

    public String getFocus() { return focus; }
    public void setFocus(String focus) { this.focus = focus; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }

    public int getEstimatedDuration() { return estimatedDuration; }
    public void setEstimatedDuration(int estimatedDuration) { this.estimatedDuration = estimatedDuration; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        this.exercises.remove(exercise);
    }
}

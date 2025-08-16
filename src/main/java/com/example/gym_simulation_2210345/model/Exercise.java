package com.example.gym_simulation_2210345.model;

public class Exercise {
    private String exerciseId;
    private String name;
    private String category;
    private int sets;
    private int reps;
    private double weight;
    private int duration; // in seconds
    private String instructions;

    public Exercise(String exerciseId, String name, String category) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.category = category;
    }


    public String getExerciseId() { return exerciseId; }
    public void setExerciseId(String exerciseId) { this.exerciseId = exerciseId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }

    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    @Override
    public String toString() {
        return name + " - " + sets + "x" + reps + " @ " + weight + "kg";
    }
}

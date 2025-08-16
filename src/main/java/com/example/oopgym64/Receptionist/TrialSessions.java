package com.example.oopgym64.Receptionist;

import java.time.LocalDate;

public class TrialSessions {
    String trainer, time, availability;
    LocalDate date;

    public TrialSessions(String trainer, String time, String availability, LocalDate date) {
        this.trainer = trainer;
        this.time = time;
        this.availability = availability;
        this.date = date;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrialSessions{" +
                "trainer='" + trainer + '\'' +
                ", time='" + time + '\'' +
                ", availability='" + availability + '\'' +
                ", date=" + date +
                '}';
    }
}

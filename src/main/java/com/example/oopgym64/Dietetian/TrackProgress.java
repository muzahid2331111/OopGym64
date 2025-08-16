package com.example.oopgym64.Dietetian;

import java.time.LocalDate;

public class TrackProgress {
    private String memberID;
    private double height; //cm
    private double weight; //kg
    LocalDate date;

    public TrackProgress(String memberID, double height, double weight, LocalDate date) {
        this.memberID = memberID;
        this.height = height;
        this.weight = weight;
        this.date = date;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
package com.example.oopgym64.Receptionist;

public class WalkinMembership {
    String plan, duration, price;

    public WalkinMembership(String plan, String duration, String price) {
        this.plan = plan;
        this.duration = duration;
        this.price = price;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

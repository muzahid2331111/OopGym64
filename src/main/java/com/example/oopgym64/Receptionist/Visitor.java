package com.example.oopgym64.Receptionist;

public class Visitor {
    String name, timing;
    int contact;

    public Visitor(String name, int contact, String timing) {
        this.name = name;
        this.contact = contact;
        this.timing = timing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", timing='" + timing + '\'' +
                ", contact=" + contact +
                '}';
    }
}
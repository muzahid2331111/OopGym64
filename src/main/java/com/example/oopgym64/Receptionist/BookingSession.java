package com.example.oopgym64.Receptionist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookingSession {
    private final StringProperty sessionID;
    private final StringProperty time;
    private final StringProperty status;

    public BookingSession(String sessionID, String time, String status) {
        this.sessionID = new SimpleStringProperty(sessionID);
        this.time = new SimpleStringProperty(time);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty sessionIDProperty() {
        return sessionID;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getSessionID() {
        return sessionID.get();
    }
}

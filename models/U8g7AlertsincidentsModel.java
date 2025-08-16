package model;

/** Model for: Handle System Alerts and Incident Reports */
public class U8g7AlertsincidentsModel {
    private String incidentId;
private String note;

    public U8g7AlertsincidentsModel(String incidentId, String note) {
        this.incidentId = incidentId;
    this.note = note;
    }

    public String getIncidentId() { return incidentId; }

public void setIncidentId(String incidentId) { this.incidentId = incidentId; }

public String getNote() { return note; }

public void setNote(String note) { this.note = note; }
}
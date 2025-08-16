package com.example.gym_simulation_2210345.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class GroupClass {
    private String classId;
    private String className;
    private String instructor;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private int maxCapacity;
    private List<String> enrolledMembers;
    private String classType;
    private boolean isPremiumOnly;
    private String description;

    public GroupClass(String classId, String className, String instructor, LocalDateTime startTime, 
                     LocalDateTime endTime, String location, int maxCapacity, String classType) {
        this.classId = classId;
        this.className = className;
        this.instructor = instructor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.classType = classType;
        this.enrolledMembers = new ArrayList<>();
        this.isPremiumOnly = false;
    }


    public String getClassId() { return classId; }
    public void setClassId(String classId) { this.classId = classId; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public List<String> getEnrolledMembers() { return enrolledMembers; }
    public void setEnrolledMembers(List<String> enrolledMembers) { this.enrolledMembers = enrolledMembers; }

    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }

    public boolean isPremiumOnly() { return isPremiumOnly; }
    public void setPremiumOnly(boolean premiumOnly) { isPremiumOnly = premiumOnly; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean enrollMember(String memberId) {
        if (enrolledMembers.size() < maxCapacity) {
            enrolledMembers.add(memberId);
            return true;
        }
        return false;
    }

    public boolean unenrollMember(String memberId) {
        return enrolledMembers.remove(memberId);
    }

    public int getAvailableSpots() {
        return maxCapacity - enrolledMembers.size();
    }

    public boolean isFull() {
        return enrolledMembers.size() >= maxCapacity;
    }
    
    @Override
    public String toString() {
        return className + " - " + instructor + " (" + startTime.format(java.time.format.DateTimeFormatter.ofPattern("MMM dd, HH:mm")) + ")";
    }
}

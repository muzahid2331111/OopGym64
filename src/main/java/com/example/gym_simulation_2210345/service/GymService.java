package com.example.gym_simulation_2210345.service;

import com.example.gym_simulation_2210345.model.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GymService {
    private Map<String, User> users;
    private Map<String, GroupClass> classes;
    private Map<String, WorkoutPlan> workoutPlans;
    private Map<String, WorkoutSession> workoutSessions;
    private Map<String, String> feedbackDatabase;

    public GymService() {
        this.users = new HashMap<>();
        this.classes = new HashMap<>();
        this.workoutPlans = new HashMap<>();
        this.workoutSessions = new HashMap<>();
        this.feedbackDatabase = new HashMap<>();
        initializeSampleData();
    }

    // User Management
    public boolean registerUser(String userId, String name, String email, String password, String membershipType) {
        if (users.containsKey(userId)) {
            return false; // User already exists
        }

        User user;
        if ("Premium".equalsIgnoreCase(membershipType)) {
            user = new PremiumMember(userId, name, email, password);
        } else {
            user = new BasicMember(userId, name, email, password);
        }

        users.put(userId, user);
        return true;
    }

    public User loginUser(String email, String password) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // Gym Session Booking
    public boolean bookGymSession(String userId, LocalDateTime startTime, String sessionType) {
        User user = users.get(userId);
        if (user == null || !user.isActive()) {
            return false;
        }

        String sessionId = "SESS_" + System.currentTimeMillis();
        WorkoutSession session = new WorkoutSession(sessionId, startTime, sessionType);
        workoutSessions.put(sessionId, session);
        
        user.getWorkoutSessions().add(session);
        return true;
    }

    // Group Class Management
    public boolean joinGroupClass(String userId, String classId) {
        User user = users.get(userId);
        GroupClass groupClass = classes.get(classId);
        
        if (user == null || groupClass == null || !user.isActive()) {
            return false;
        }

        if (user instanceof BasicMember) {
            BasicMember basicMember = (BasicMember) user;
            if (!basicMember.canJoinClass(groupClass)) {
                return false;
            }
        } else if (user instanceof PremiumMember) {
            PremiumMember premiumMember = (PremiumMember) user;
            if (!premiumMember.canJoinPremiumClass(groupClass)) {
                return false;
            }
        }

        if (groupClass.enrollMember(userId)) {
            user.getEnrolledClasses().add(groupClass);
            return true;
        }
        return false;
    }

    public boolean leaveGroupClass(String userId, String classId) {
        User user = users.get(userId);
        GroupClass groupClass = classes.get(classId);
        
        if (user == null || groupClass == null) {
            return false;
        }

        if (groupClass.unenrollMember(userId)) {
            user.getEnrolledClasses().removeIf(c -> c.getClassId().equals(classId));
            return true;
        }
        return false;
    }

    // Workout Plan Management
    public WorkoutPlan createWorkoutPlan(String userId, String goal) {
        User user = users.get(userId);
        if (user == null) {
            return null;
        }

        String planId = "PLAN_" + System.currentTimeMillis();
        WorkoutPlan plan = new WorkoutPlan(planId, userId, goal);
        workoutPlans.put(planId, plan);
        user.setWorkoutPlan(plan);
        return plan;
    }

    public WorkoutPlan getUserWorkoutPlan(String userId) {
        User user = users.get(userId);
        return user != null ? user.getWorkoutPlan() : null;
    }

    // Progress Tracking
    public List<WorkoutSession> getUserWorkoutHistory(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        User user = users.get(userId);
        if (user == null) {
            return new ArrayList<>();
        }

        return user.getWorkoutSessions().stream()
                .filter(session -> session.getStartTime().isAfter(startDate) && session.getStartTime().isBefore(endDate))
                .collect(Collectors.toList());
    }

    // Feedback System
    public boolean submitFeedback(String userId, String sessionId, String feedback) {
        if (!users.containsKey(userId) || !workoutSessions.containsKey(sessionId)) {
            return false;
        }

        String feedbackId = "FB_" + System.currentTimeMillis();
        feedbackDatabase.put(feedbackId, feedback);
        return true;
    }

    // Class Schedule
    public List<GroupClass> getClassSchedule() {
        return new ArrayList<>(classes.values());
    }

    public List<GroupClass> getAvailableClasses() {
        return classes.values().stream()
                .filter(c -> !c.isFull())
                .collect(Collectors.toList());
    }

    // Profile Management
    public boolean updateUserProfile(String userId, String name, String phoneNumber, double weight, double height) {
        User user = users.get(userId);
        if (user == null) {
            return false;
        }

        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setWeight(weight);
        user.setHeight(height);
        return true;
    }

    // Premium Member Specific Services
    public boolean bookPersonalTraining(String userId, String trainerId, LocalDateTime appointmentTime) {
        User user = users.get(userId);
        if (!(user instanceof PremiumMember)) {
            return false;
        }

        PremiumMember premiumMember = (PremiumMember) user;
        if (!premiumMember.canBookPersonalTraining()) {
            return false;
        }

        // For now, just set the trainer ID
        premiumMember.setPersonalTrainer(trainerId);
        return true;
    }

    public boolean bookWellnessLounge(String userId, String service, LocalDateTime appointmentTime) {
        User user = users.get(userId);
        if (!(user instanceof PremiumMember)) {
            return false;
        }

        PremiumMember premiumMember = (PremiumMember) user;
        if (!premiumMember.canAccessWellnessLounge()) {
            return false;
        }

        String appointmentId = "WL_" + System.currentTimeMillis();
        premiumMember.addWellnessAppointment(appointmentId);
        return true;
    }

    // Getters for data
    public Map<String, User> getUsers() { return users; }
    public Map<String, GroupClass> getClasses() { return classes; }
    public Map<String, WorkoutPlan> getWorkoutPlans() { return workoutPlans; }
    public Map<String, WorkoutSession> getWorkoutSessions() { return workoutSessions; }

    // Initialize sample data
    private void initializeSampleData() {
        // Create sample classes
        LocalDateTime now = LocalDateTime.now();
        
        GroupClass yogaClass = new GroupClass("CLASS_001", "Morning Yoga", "Sarah Johnson", 
            now.plusDays(1).withHour(7).withMinute(0), 
            now.plusDays(1).withHour(8).withMinute(0), 
            "Studio A", 20, "Yoga");
        classes.put("CLASS_001", yogaClass);

        GroupClass cardioClass = new GroupClass("CLASS_002", "HIIT Cardio", "Mike Chen", 
            now.plusDays(1).withHour(18).withMinute(0), 
            now.plusDays(1).withHour(19).withMinute(0), 
            "Studio B", 15, "Cardio");
        classes.put("CLASS_002", cardioClass);

        GroupClass premiumClass = new GroupClass("CLASS_003", "Advanced Strength Training", "Alex Rodriguez", 
            now.plusDays(2).withHour(17).withMinute(0), 
            now.plusDays(2).withHour(18).withMinute(30), 
            "Premium Studio", 10, "Strength");
        premiumClass.setPremiumOnly(true);
        classes.put("CLASS_003", premiumClass);
    }
}

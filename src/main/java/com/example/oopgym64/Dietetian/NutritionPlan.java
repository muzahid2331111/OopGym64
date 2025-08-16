package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NutritionPlan {
    private String memberID;
     String mealPlan;
     private String planDetails;

    public NutritionPlan(String memberID, String planDetails, String plan) {
        this.memberID = memberID;
        this.planDetails = planDetails;
        this.mealPlan = plan;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String plan) {
        this.mealPlan = plan;
    }

}


package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ExpenseRevenueExampleController {

    @FXML private TextField expenseField;
    @FXML private TextField expenseCategoryField;
    @FXML private TextField revenueField;
    @FXML private TextField revenueSourceField;
    @FXML private Label reportLabel;

    private double totalExpense = 0;
    private double totalRevenue = 0;

    @FXML
    public void recordExpense() {
        try {
            double expense = Double.parseDouble(expenseField.getText());
            String category = expenseCategoryField.getText();
            totalExpense += expense;
            reportLabel.setText("Expense Recorded: " + category + " - " + expense);
        } catch (NumberFormatException e) {
            reportLabel.setText("Invalid expense amount!");
        }
    }

    @FXML
    public void recordRevenue() {
        try {
            double revenue = Double.parseDouble(revenueField.getText());
            String source = revenueSourceField.getText();
            totalRevenue += revenue;

            String summary = "Revenue Recorded: " + source + " - " + revenue + "\n";
            summary += "Daily Report: Income = " + totalRevenue + ", Expenses = " + totalExpense;

            if (totalExpense > totalRevenue) {
                summary += "\n⚠ Warning: Expenses exceed income!";
            }
            reportLabel.setText(summary);
        } catch (NumberFormatException e) {
            reportLabel.setText("Invalid revenue amount!");
        }
    }
}
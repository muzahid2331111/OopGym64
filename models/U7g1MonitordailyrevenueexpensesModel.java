package model;

/** Model for: Monitor Daily Revenue and Expenses */
public class U7g1MonitordailyrevenueexpensesModel {
    private double expense;
private String expenseCategory;
private double revenue;
private String revenueSource;

    public U7g1MonitordailyrevenueexpensesModel(double expense, String expenseCategory, double revenue, String revenueSource) {
        this.expense = expense;
    this.expenseCategory = expenseCategory;
    this.revenue = revenue;
    this.revenueSource = revenueSource;
    }

    public double getExpense() { return expense; }

public void setExpense(double expense) { this.expense = expense; }

public String getExpenseCategory() { return expenseCategory; }

public void setExpenseCategory(String expenseCategory) { this.expenseCategory = expenseCategory; }

public double getRevenue() { return revenue; }

public void setRevenue(double revenue) { this.revenue = revenue; }

public String getRevenueSource() { return revenueSource; }

public void setRevenueSource(String revenueSource) { this.revenueSource = revenueSource; }
}
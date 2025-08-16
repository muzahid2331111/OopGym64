package model;

/** Model for: Prepare Monthly Financial Statements */
public class U7g3PreparemonthlyfinancialstatementsModel {
    private String period;
private String comments;

    public U7g3PreparemonthlyfinancialstatementsModel(String period, String comments) {
        this.period = period;
    this.comments = comments;
    }

    public String getPeriod() { return period; }

public void setPeriod(String period) { this.period = period; }

public String getComments() { return comments; }

public void setComments(String comments) { this.comments = comments; }
}
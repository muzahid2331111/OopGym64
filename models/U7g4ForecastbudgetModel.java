package model;

/** Model for: Forecast Budget for Future Operations */
public class U7g4ForecastbudgetModel {
    private double costIncreasePct;
private double revenueProjection;

    public U7g4ForecastbudgetModel(double costIncreasePct, double revenueProjection) {
        this.costIncreasePct = costIncreasePct;
    this.revenueProjection = revenueProjection;
    }

    public double getCostIncreasePct() { return costIncreasePct; }

public void setCostIncreasePct(double costIncreasePct) { this.costIncreasePct = costIncreasePct; }

public double getRevenueProjection() { return revenueProjection; }

public void setRevenueProjection(double revenueProjection) { this.revenueProjection = revenueProjection; }
}
package model;

/** Model for: Configure and Maintain Security Policies */
public class U8g5SecuritypoliciesModel {
    private int minPasswordLength;
private boolean twoFactorEnabled;

    public U8g5SecuritypoliciesModel(int minPasswordLength, boolean twoFactorEnabled) {
        this.minPasswordLength = minPasswordLength;
    this.twoFactorEnabled = twoFactorEnabled;
    }

    public int getMinPasswordLength() { return minPasswordLength; }

public void setMinPasswordLength(int minPasswordLength) { this.minPasswordLength = minPasswordLength; }

public boolean getTwoFactorEnabled() { return twoFactorEnabled; }

public void setTwoFactorEnabled(boolean twoFactorEnabled) { this.twoFactorEnabled = twoFactorEnabled; }
}
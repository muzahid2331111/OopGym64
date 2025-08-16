package model;

/** Model for: Ensure System Data Backup and Recovery */
public class U8g2BackuprecoveryModel {
    private String backupName;

    public U8g2BackuprecoveryModel(String backupName) {
        this.backupName = backupName;
    }

    public String getBackupName() { return backupName; }

public void setBackupName(String backupName) { this.backupName = backupName; }
}
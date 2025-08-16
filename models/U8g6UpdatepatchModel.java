package model;

/** Model for: Update and Patch System Software */
public class U8g6UpdatepatchModel {
    private String softwareName;
private String version;

    public U8g6UpdatepatchModel(String softwareName, String version) {
        this.softwareName = softwareName;
    this.version = version;
    }

    public String getSoftwareName() { return softwareName; }

public void setSoftwareName(String softwareName) { this.softwareName = softwareName; }

public String getVersion() { return version; }

public void setVersion(String version) { this.version = version; }
}
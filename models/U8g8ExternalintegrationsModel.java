package model;

/** Model for: Ensure Integration with External Systems */
public class U8g8ExternalintegrationsModel {
    private String serviceName;
private String apiKey;

    public U8g8ExternalintegrationsModel(String serviceName, String apiKey) {
        this.serviceName = serviceName;
    this.apiKey = apiKey;
    }

    public String getServiceName() { return serviceName; }

public void setServiceName(String serviceName) { this.serviceName = serviceName; }

public String getApiKey() { return apiKey; }

public void setApiKey(String apiKey) { this.apiKey = apiKey; }
}
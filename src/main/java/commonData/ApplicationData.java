package commonData;

/**
 * Enumeration representing application data for different applications.
 */
public enum ApplicationData {
    WEBSITE(DataTransferProtocol.HTTP.getProtocol(), DomainName.WEBSITE.getDomainName()),
    MOBILE(DataTransferProtocol.HTTP.getProtocol(), DomainName.MOBILE.getDomainName()),
    MARKETPLACE(DataTransferProtocol.HTTP.getProtocol(), DomainName.MARKETPLACE.getDomainName());
    private String protocol;
    private String domain;

    ApplicationData(String protocol, String domain){
        this.protocol = protocol;
        this.domain = domain;
    }

    public String getProtocol(){ return protocol;}
    public String getDomainName(){ return domain;}

    public String getURL() {
        return protocol + domain;
    }
}

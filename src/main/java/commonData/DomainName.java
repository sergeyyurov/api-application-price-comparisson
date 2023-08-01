package commonData;

/**
 * Enumeration representing domain names for different applications.
 */
public enum DomainName {
    MOBILE("mobile.data.com"),
    WEBSITE("website.data.com"),
    MARKETPLACE("marketplace.data.com");

    private String domainName;

    DomainName(String domainName){
        this.domainName = domainName;
    }

    public String getDomainName(){ return domainName;}
}
